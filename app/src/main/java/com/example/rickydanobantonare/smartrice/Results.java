package com.example.rickydanobantonare.smartrice;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.wonderkiln.camerakit.CameraKitError;
import com.wonderkiln.camerakit.CameraKitEvent;
import com.wonderkiln.camerakit.CameraKitEventListener;
import com.wonderkiln.camerakit.CameraKitImage;
import com.wonderkiln.camerakit.CameraKitVideo;
import com.wonderkiln.camerakit.CameraView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Results extends AppCompatActivity{

    private static final String MODEL_PATH = "graph.tflite";
    private static final String LABEL_PATH = "labels.txt";
    private static final int INPUT_SIZE = 224;

    private Classifier classifier;

    private Executor executor = Executors.newSingleThreadExecutor();
    private Button btnDetectObject;
    private ImageView imageViewResult;
    private CameraView cameraView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        cameraView = findViewById(R.id.cameraView);
        imageViewResult = findViewById(R.id.imageViewResult);

        btnDetectObject = findViewById(R.id.btnDetectObject);

        listView = findViewById(R.id.listView);

        ImageButton androidImageButton = (ImageButton) findViewById(R.id.imageButton3);
        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backActivity();
            }
        });

        imageViewResult.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.INVISIBLE);

        cameraView.addCameraKitListener(new CameraKitEventListener() {
            @Override
            public void onEvent(CameraKitEvent cameraKitEvent) {

            }

            @Override
            public void onError(CameraKitError cameraKitError) {

            }

            @Override
            public void onImage(CameraKitImage cameraKitImage) {

                Bitmap bitmap = cameraKitImage.getBitmap();
                bitmap = Bitmap.createScaledBitmap(bitmap, INPUT_SIZE, INPUT_SIZE, false);
                imageViewResult.setImageBitmap(bitmap);

                final List<Classifier.Recognition> results = classifier.recognizeImage(bitmap);

                ArrayList<HashMap<String, String>> listItems = new ArrayList<>();
                HashMap<String, String> listItemData;

                for (int i=0; i<results.size(); i++) {

                    if (results.size() != 0) {
                        listItemData = new HashMap<String, String>();
                        String resultStr = results.get(i).toString();
                        String[] resultStrVar = resultStr.split(",");

                        listItemData.put("disease_name", resultStrVar[0]);
                        listItemData.put("confidence", resultStrVar[1]);

                        listItems.add(listItemData);

                    } else {
                        listItemData = new HashMap<String, String>();
                        listItemData.put("disease_name", "No predictions found");
                        listItemData.put("confidence", "Kindly shot again");

                        listItems.add(listItemData);
                    }
                }

                SimpleAdapter adapter = new SimpleAdapter(Results.this, listItems,
                        android.R.layout.simple_list_item_2,
                        new String[] {"disease_name", "confidence"},
                        new int[] {android.R.id.text1, android.R.id.text2 });

                listView.setAdapter(adapter);
            }

            @Override
            public void onVideo(CameraKitVideo cameraKitVideo) {

            }
        });

        btnDetectObject.setTag(1);
        btnDetectObject.setText("Capture and Analyze");

        btnDetectObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int status = (Integer) v.getTag();

                if (status == 1) {
                    cameraView.captureImage();
                    cameraView.setVisibility(v.INVISIBLE);
                    imageViewResult.setVisibility(v.VISIBLE);
                    listView.setVisibility(v.VISIBLE);
                    btnDetectObject.setText("Detect Again");
                    v.setTag(0);
                } else {
                    cameraView.setVisibility(v.VISIBLE);
                    imageViewResult.setVisibility(v.INVISIBLE);
                    listView.setVisibility(v.INVISIBLE);
                    btnDetectObject.setText("Capture and Analyze");
                    Restart();
                    v.setTag(1);
                }

            }
        });

        initTensorFlowAndLoadModel();
    }

    public void Restart()
    {
        this.recreate();
    }

    public void backActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        cameraView.start();
    }

    @Override
    protected void onPause() {
        cameraView.stop();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                classifier.close();
            }
        });
    }

    private void initTensorFlowAndLoadModel() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    classifier = TensorFlowImageClassifier.create(
                            getAssets(),
                            MODEL_PATH,
                            LABEL_PATH,
                            INPUT_SIZE);
                    makeButtonVisible();
                } catch (final Exception e) {
                    throw new RuntimeException("Error initializing TensorFlow!", e);
                }
            }
        });
    }

    private void makeButtonVisible() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                btnDetectObject.setVisibility(View.VISIBLE);
            }
        });
    }
}