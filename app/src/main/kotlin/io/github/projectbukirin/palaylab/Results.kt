package io.github.projectbukirin.palaylab

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.wonderkiln.camerakit.*
import io.github.projectbukirin.palaylab.DiseasesDefinition.*
import io.github.projectbukirin.palaylab.PestsDefinition.*
import java.io.FileNotFoundException
import java.io.InputStream
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class Results : AppCompatActivity() {
    private var classifier: Classifier? = null
    private val executor: Executor = Executors.newSingleThreadExecutor()
    private var btnDetectObject: Button? = null
    private var btnDetectObject2: Button? = null
    private var btnDetectObjectCam: Button? = null
    private var btnDetectSelectImage: Button? = null
    private var btnDetectObjectFromCam: Button? = null
    private var imageViewResult: ImageView? = null
    private var cameraView: CameraView? = null
    private var listView: ListView? = null
    private var textView: TextView? = null
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        auth = FirebaseAuth.getInstance()

        if(auth.currentUser == null){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Already logged in", Toast.LENGTH_LONG).show()
        }

        setSupportActionBar(findViewById(R.id.toolbar_results))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detect"

        cameraView = findViewById(R.id.cameraView)
        imageViewResult = findViewById(R.id.imageViewResult)
        btnDetectObject = findViewById(R.id.btnDetectObject)
        btnDetectObject2 = findViewById(R.id.btnDetectObject2)
        btnDetectObjectCam = findViewById(R.id.btnDetectObjectCam)
        btnDetectSelectImage = findViewById(R.id.btnDetectSelectImage)
        btnDetectObjectFromCam = findViewById(R.id.btnDetectObjectFromCam)
        listView = findViewById(R.id.listView)
        textView = findViewById(R.id.textView3)
        btnDetectObject2?.visibility = View.INVISIBLE
        imageViewResult?.visibility = View.INVISIBLE
        btnDetectSelectImage?.visibility = View.INVISIBLE
        btnDetectObjectFromCam?.visibility = View.INVISIBLE
        listView?.visibility = View.INVISIBLE
        cameraView?.addCameraKitListener(object : CameraKitEventListener {
            override fun onEvent(cameraKitEvent: CameraKitEvent) {}
            override fun onError(cameraKitError: CameraKitError) {}
            override fun onImage(cameraKitImage: CameraKitImage) {
                var bitmap = cameraKitImage.bitmap
                bitmap = Bitmap.createScaledBitmap(bitmap, INPUT_SIZE, INPUT_SIZE, false)
                imageViewResult?.setImageBitmap(bitmap)
                val results = classifier!!.recognizeImage(bitmap)
                val listItems = ArrayList<HashMap<String, String>>()
                var listItemData: HashMap<String, String>
                val db = DatabaseHelper(this@Results)
                for (i in results!!.indices) {
                    if (results.size != 0) {
                        listItemData = HashMap()
                        val resultStr = results[i].toString()
                        val resultStrVar = resultStr.split(",").toTypedArray()
                        listItemData["disease_name"] = resultStrVar[0]
                        listItemData["confidence"] = resultStrVar[1]
                        listItems.add(listItemData)
                    } else {
                        listItemData = HashMap()
                        listItemData["disease_name"] = "No predictions found"
                        listItemData["confidence"] = "Kindly shot again"
                        listItems.add(listItemData)
                    }
                }
                val stringNames = arrayOfNulls<String>(listItems.size)
                val stringConfidence = arrayOfNulls<String>(listItems.size)
                val intImage = arrayOfNulls<Int>(listItems.size)
                for (i in listItems.indices) {
                    if (listItems.size != 0) {
                        stringNames[i] = listItems[i]["disease_name"]
                        stringConfidence[i] = listItems[i]["confidence"]
                        val current = listItems[i]["disease_name"]
                        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd")
                        val date = Date()
                        val dateToday = dateFormat.format(date)
                        db.addInfo(StatisticsInfo(stringNames[i], dateToday, stringConfidence[i]))
                        if (current == "Army Worm") {
                            intImage[i] = R.drawable.armyworm
                        } else if (current == "Bacterial Leaf Blight") {
                            intImage[i] = R.drawable.bacterialblight
                        } else if (current == "Black Bug") {
                            intImage[i] = R.drawable.riceblackbug
                        } else if (current == "Blast") {
                            intImage[i] = R.drawable.riceblast
                        } else if (current == "Ear Bug") {
                            intImage[i] = R.drawable.riceearbug
                        } else if (current == "Golden Apple Snail") {
                            intImage[i] = R.drawable.goldenapplesnail
                        } else if (current == "Green Leafhopper") {
                            intImage[i] = R.drawable.greenleafhopper
                        } else if (current == "Sheath Blight") {
                            intImage[i] = R.drawable.sheathblight
                        } else if (current == "Tungro") {
                            intImage[i] = R.drawable.tungro
                        }
                    } else {
                        // Change this into something blank
                        intImage[i] = R.drawable.roundbutton
                    }
                }
                val customListView = CustomListView(this@Results,
                        stringNames,
                        stringConfidence,
                        intImage)
                listView?.adapter = customListView
                listView?.onItemClickListener = OnItemClickListener { adapterView, view, position, l ->
                    if (stringNames[position] == "Army Worm") {
                        val intent = Intent()
                        intent.setClass(this@Results, PestsDefinition::class.java)
                        startActivity(intent)
                    } else if (stringNames[position] == "Bacterial Leaf Blight") {
                        val intent = Intent()
                        intent.setClass(this@Results, DiseasesDefinition::class.java)
                        startActivity(intent)
                    } else if (stringNames[position] == "Black Bug") {
                        val intent = Intent()
                        intent.setClass(this@Results, PestDefinition4::class.java)
                        startActivity(intent)
                    } else if (stringNames[position] == "Blast") {
                        val intent = Intent()
                        intent.setClass(this@Results, DiseaseDefinition2::class.java)
                        startActivity(intent)
                    } else if (stringNames[position] == "Ear Bug") {
                        val intent = Intent()
                        intent.setClass(this@Results, PestDefinition5::class.java)
                        startActivity(intent)
                    } else if (stringNames[position] == "Golden Apple Snail") {
                        val intent = Intent()
                        intent.setClass(this@Results, PestDefinition2::class.java)
                        startActivity(intent)
                    } else if (stringNames[position] == "Green Leafhopper") {
                        val intent = Intent()
                        intent.setClass(this@Results, PestDefinition3::class.java)
                        startActivity(intent)
                    } else if (stringNames[position] == "Sheath Blight") {
                        val intent = Intent()
                        intent.setClass(this@Results, DiseaseDefinition3::class.java)
                        startActivity(intent)
                    } else if (stringNames[position] == "Tungro") {
                        val intent = Intent()
                        intent.setClass(this@Results, DiseaseDefinition4::class.java)
                        startActivity(intent)
                    }
                }
            }

            override fun onVideo(cameraKitVideo: CameraKitVideo) {}
        })
        btnDetectObject2?.setOnClickListener(View.OnClickListener { Restart() })
        btnDetectObject?.setOnClickListener(View.OnClickListener {
            cameraView?.captureImage()
            cameraView?.visibility = View.INVISIBLE
            imageViewResult?.visibility = View.VISIBLE
            listView?.visibility = View.VISIBLE
            btnDetectObject?.visibility = View.INVISIBLE
            btnDetectObjectCam?.visibility = View.INVISIBLE
            setSupportActionBar(findViewById(R.id.toolbar_results))
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "Results"
            btnDetectObject2?.visibility = View.VISIBLE
        })
        btnDetectObjectCam?.setOnClickListener(View.OnClickListener {
            cameraView?.visibility = View.INVISIBLE
            btnDetectObject?.visibility = View.INVISIBLE
            listView?.visibility = View.VISIBLE
            imageViewResult?.visibility = View.VISIBLE
            btnDetectObjectCam?.visibility = View.INVISIBLE
            btnDetectSelectImage?.visibility = View.VISIBLE
        })
        btnDetectSelectImage?.setOnClickListener(View.OnClickListener {
            val getIntent = Intent(Intent.ACTION_GET_CONTENT)
            getIntent.type = "image/*"
            val pickIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            pickIntent.type = "image/*"
            val chooserIntent = Intent.createChooser(getIntent, "Select Image")
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(pickIntent))
            startActivityForResult(chooserIntent, PICK_IMAGE)
            btnDetectObjectFromCam?.visibility = View.VISIBLE
        })
        btnDetectObjectFromCam?.setOnClickListener(View.OnClickListener {
            btnDetectObject2?.visibility = View.VISIBLE
            btnDetectObjectFromCam?.visibility = View.INVISIBLE
            btnDetectSelectImage?.visibility = View.INVISIBLE
            textView?.text = "Results"
            var bitmap = (imageViewResult?.getDrawable() as BitmapDrawable).bitmap
            bitmap = Bitmap.createScaledBitmap(bitmap, INPUT_SIZE, INPUT_SIZE, false)
            imageViewResult?.setImageBitmap(bitmap)
            val results = classifier!!.recognizeImage(bitmap)
            val listItems = ArrayList<HashMap<String, String>>()
            var listItemData: HashMap<String, String>
            val db = DatabaseHelper(this@Results)
            for (i in results!!.indices) {
                if (results.isNotEmpty()) {
                    listItemData = HashMap()
                    val resultStr = results[i].toString()
                    val resultStrVar = resultStr.split(",").toTypedArray()
                    listItemData["disease_name"] = resultStrVar[0]
                    listItemData["confidence"] = resultStrVar[1]
                    listItems.add(listItemData)
                } else {
                    listItemData = HashMap()
                    listItemData["disease_name"] = "No predictions found"
                    listItemData["confidence"] = "Kindly shot again"
                    listItems.add(listItemData)
                }
            }
            val stringNames = arrayOfNulls<String>(listItems.size)
            val stringConfidence = arrayOfNulls<String>(listItems.size)
            val intImage = arrayOfNulls<Int>(listItems.size)
            for (i in listItems.indices) {
                if (listItems.size != 0) {
                    stringNames[i] = listItems[i]["disease_name"]
                    stringConfidence[i] = listItems[i]["confidence"]
                    val current = listItems[i]["disease_name"]
                    val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd")
                    val date = Date()
                    val dateToday = dateFormat.format(date)
                    db.addInfo(StatisticsInfo(stringNames[i], dateToday, stringConfidence[i]))
                    if (current == "Army Worm") {
                        intImage[i] = R.drawable.armyworm
                    } else if (current == "Bacterial Leaf Blight") {
                        intImage[i] = R.drawable.bacterialblight
                    } else if (current == "Black Bug") {
                        intImage[i] = R.drawable.riceblackbug
                    } else if (current == "Blast") {
                        intImage[i] = R.drawable.riceblast
                    } else if (current == "Ear Bug") {
                        intImage[i] = R.drawable.riceearbug
                    } else if (current == "Golden Apple Snail") {
                        intImage[i] = R.drawable.goldenapplesnail
                    } else if (current == "Green Leafhopper") {
                        intImage[i] = R.drawable.greenleafhopper
                    } else if (current == "Sheath Blight") {
                        intImage[i] = R.drawable.sheathblight
                    } else if (current == "Tungro") {
                        intImage[i] = R.drawable.tungro
                    }
                } else {
                    // Change this into something blank
                    intImage[i] = R.drawable.roundbutton
                }
            }
            val customListView = CustomListView(this@Results,
                    stringNames,
                    stringConfidence,
                    intImage)
            listView?.adapter = customListView
            listView?.onItemClickListener = OnItemClickListener { adapterView, view, position, l ->
                if (stringNames[position] == "Army Worm") {
                    val intent = Intent()
                    intent.setClass(this@Results, PestsDefinition::class.java)
                    startActivity(intent)
                } else if (stringNames[position] == "Bacterial Leaf Blight") {
                    val intent = Intent()
                    intent.setClass(this@Results, DiseasesDefinition::class.java)
                    startActivity(intent)
                } else if (stringNames[position] == "Black Bug") {
                    val intent = Intent()
                    intent.setClass(this@Results, PestDefinition4::class.java)
                    startActivity(intent)
                } else if (stringNames[position] == "Blast") {
                    val intent = Intent()
                    intent.setClass(this@Results, DiseaseDefinition2::class.java)
                    startActivity(intent)
                } else if (stringNames[position] == "Ear Bug") {
                    val intent = Intent()
                    intent.setClass(this@Results, PestDefinition5::class.java)
                    startActivity(intent)
                } else if (stringNames[position] == "Golden Apple Snail") {
                    val intent = Intent()
                    intent.setClass(this@Results, PestDefinition2::class.java)
                    startActivity(intent)
                } else if (stringNames[position] == "Green Leafhopper") {
                    val intent = Intent()
                    intent.setClass(this@Results, PestDefinition3::class.java)
                    startActivity(intent)
                } else if (stringNames[position] == "Sheath Blight") {
                    val intent = Intent()
                    intent.setClass(this@Results, DiseaseDefinition3::class.java)
                    startActivity(intent)
                } else if (stringNames[position] == "Tungro") {
                    val intent = Intent()
                    intent.setClass(this@Results, DiseaseDefinition4::class.java)
                    startActivity(intent)
                }
            }
        })
        initTensorFlowAndLoadModel()
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            val imageUri = data!!.data
            val inputStream: InputStream
            try {
                inputStream = contentResolver.openInputStream(imageUri)
                val image = BitmapFactory.decodeStream(inputStream)
                imageViewResult!!.setImageBitmap(image)
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            }
        }
    }

    fun Restart() {
        recreate()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.settings_actionbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_settings -> {
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    override fun onResume() {
        super.onResume()
        cameraView!!.start()
    }

    override fun onPause() {
        cameraView!!.stop()
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        executor.execute { classifier!!.close() }
    }

    private fun initTensorFlowAndLoadModel() {
        executor.execute {
            try {
                classifier = TensorFlowImageClassifier.create(
                        assets,
                        MODEL_PATH,
                        LABEL_PATH,
                        INPUT_SIZE)
                makeButtonVisible()
            } catch (e: Exception) {
                throw RuntimeException("Error initializing TensorFlow!", e)
            }
        }
    }

    private fun makeButtonVisible() {
        runOnUiThread { btnDetectObject!!.visibility = View.VISIBLE }
    }

    companion object {
        private const val MODEL_PATH = "graph.tflite"
        private const val LABEL_PATH = "labels.txt"
        private const val INPUT_SIZE = 224
        const val PICK_IMAGE = 1
    }
}