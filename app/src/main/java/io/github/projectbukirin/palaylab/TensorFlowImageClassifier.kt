package io.github.projectbukirin.palaylab

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.res.AssetManager
import android.graphics.Bitmap
import android.os.SystemClock
import android.util.Log
import io.github.projectbukirin.palaylab.Classifier.Recognition
import org.tensorflow.lite.Interpreter
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStreamReader
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel
import java.util.*

class TensorFlowImageClassifier private constructor() : Classifier {
    private var interpreter: Interpreter? = null
    private var inputSize = 0
    private var labelList: List<String>? = null
    override fun recognizeImage(bitmap: Bitmap?): List<Recognition?>? {
        val byteBuffer = convertBitmapToByteBuffer(bitmap)
        val result = Array(1) { FloatArray(labelList!!.size) }
        val startTime = SystemClock.uptimeMillis()
        interpreter!!.run(byteBuffer, result)
        val endTime = SystemClock.uptimeMillis()
        val runTime = (endTime - startTime).toString()
        Log.d(ContentValues.TAG, "recognizeImageInInterpreter: " + runTime + "ms")
        return getSortedResult(result)
    }

    override fun close() {
        interpreter!!.close()
        interpreter = null
    }

    @Throws(IOException::class)
    private fun loadModelFile(assetManager: AssetManager, modelPath: String): MappedByteBuffer {
        val fileDescriptor = assetManager.openFd(modelPath)
        val inputStream = FileInputStream(fileDescriptor.fileDescriptor)
        val fileChannel = inputStream.channel
        val startOffset = fileDescriptor.startOffset
        val declaredLength = fileDescriptor.declaredLength
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength)
    }

    @Throws(IOException::class)
    private fun loadLabelList(assetManager: AssetManager, labelPath: String): List<String> {
        val labelList: MutableList<String> = ArrayList()
        val reader = BufferedReader(InputStreamReader(assetManager.open(labelPath)))
        var line: String
        while (reader.readLine().also { line = it } != null) {
            labelList.add(line)
        }
        reader.close()
        return labelList
    }

    private fun convertBitmapToByteBuffer(bitmap: Bitmap?): ByteBuffer {
        val byteBuffer = ByteBuffer.allocateDirect(4 * BATCH_SIZE * inputSize * inputSize * PIXEL_SIZE)
        byteBuffer.order(ByteOrder.nativeOrder())
        val intValues = IntArray(inputSize * inputSize)
        bitmap!!.getPixels(intValues, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)
        var pixel = 0
        for (i in 0 until inputSize) {
            for (j in 0 until inputSize) {
                val `val` = intValues[pixel++]
                byteBuffer.putFloat(((`val` shr 16 and 0xFF) - IMAGE_MEAN) / IMAGE_STD)
                byteBuffer.putFloat(((`val` shr 8 and 0xFF) - IMAGE_MEAN) / IMAGE_STD)
                byteBuffer.putFloat(((`val` and 0xFF) - IMAGE_MEAN) / IMAGE_STD)
            }
        }
        return byteBuffer
    }

    @SuppressLint("DefaultLocale")
    private fun getSortedResult(labelProbArray: Array<FloatArray>): List<Recognition?> {
        val pq = PriorityQueue<Recognition>(
                MAX_RESULTS
        ) { lhs, rhs -> java.lang.Float.compare(rhs.confidence!!, lhs.confidence!!) }
        for (i in labelList!!.indices) {
            val confidence = labelProbArray[0][i] * 100 / 127.0f
            if (confidence > THRESHOLD) {
                pq.add(Recognition("" + i,
                        if (labelList!!.size > i) labelList!![i] else "unknown",
                        confidence))
            }
        }
        val recognitions = ArrayList<Recognition?>()
        val recognitionsSize = Math.min(pq.size, MAX_RESULTS)
        for (i in 0 until recognitionsSize) {
            recognitions.add(pq.poll())
        }
        return recognitions
    }

    companion object {
        private const val MAX_RESULTS = 5
        private const val BATCH_SIZE = 1
        private const val PIXEL_SIZE = 3
        private const val THRESHOLD = 0.1f
        private const val IMAGE_MEAN = 128
        private const val IMAGE_STD = 128.0f
        @Throws(IOException::class)
        fun create(assetManager: AssetManager,
                   modelPath: String,
                   labelPath: String,
                   inputSize: Int): Classifier {
            val classifier = TensorFlowImageClassifier()
            classifier.interpreter = Interpreter(classifier.loadModelFile(assetManager, modelPath))
            classifier.labelList = classifier.loadLabelList(assetManager, labelPath)
            classifier.inputSize = inputSize
            return classifier
        }
    }
}