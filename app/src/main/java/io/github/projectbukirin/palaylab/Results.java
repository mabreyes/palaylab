package io.github.projectbukirin.palaylab;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ListView;

import com.wonderkiln.camerakit.CameraKitError;
import com.wonderkiln.camerakit.CameraKitEvent;
import com.wonderkiln.camerakit.CameraKitEventListener;
import com.wonderkiln.camerakit.CameraKitImage;
import com.wonderkiln.camerakit.CameraKitVideo;
import com.wonderkiln.camerakit.CameraView;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Results extends AppCompatActivity {

    private static final String MODEL_PATH = "graph.tflite";
    private static final String LABEL_PATH = "labels.txt";
    private static final int INPUT_SIZE = 224;
    public static final int PICK_IMAGE = 1;

    private Classifier classifier;

    private Executor executor = Executors.newSingleThreadExecutor();
    private Button btnDetectObject, btnDetectObject2, btnDetectObjectCam, btnDetectSelectImage, btnDetectObjectFromCam;
    private ImageView imageViewResult;
    private CameraView cameraView;
    private ListView listView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        cameraView = findViewById(R.id.cameraView);
        imageViewResult = findViewById(R.id.imageViewResult);

        btnDetectObject = findViewById(R.id.btnDetectObject);
        btnDetectObject2 = findViewById(R.id.btnDetectObject2);
        btnDetectObjectCam = findViewById(R.id.btnDetectObjectCam);
        btnDetectSelectImage = findViewById(R.id.btnDetectSelectImage);
        btnDetectObjectFromCam = findViewById(R.id.btnDetectObjectFromCam);

        listView = findViewById(R.id.listView);

        ImageButton androidImageButton = (ImageButton) findViewById(R.id.imageButton3);
        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backActivity();
            }
        });

        textView = findViewById(R.id.textView3);

        btnDetectObject2.setVisibility(View.INVISIBLE);
        imageViewResult.setVisibility(View.INVISIBLE);
        btnDetectSelectImage.setVisibility(View.INVISIBLE);
        btnDetectObjectFromCam.setVisibility(View.INVISIBLE);
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

                final ArrayList<HashMap<String, String>> listItems = new ArrayList<>();
                HashMap<String, String> listItemData;

                DatabaseHelper db = new DatabaseHelper(Results.this);

                for (int i = 0; i < results.size(); i++) {

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

                final String[] stringNames = new String[listItems.size()];
                String[] stringConfidence = new String[listItems.size()];
                Integer[] intImage = new Integer[listItems.size()];

                for (int i = 0; i < listItems.size(); i++) {
                    if (listItems.size() != 0) {
                        stringNames[i] = listItems.get(i).get("disease_name");
                        stringConfidence[i] = listItems.get(i).get("confidence");
                        String current = listItems.get(i).get("disease_name");

                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                        Date date = new Date();

                        String dateToday = dateFormat.format(date);

                        db.addInfo(new StatisticsInfo(stringNames[i], dateToday, stringConfidence[i]));

                        if (current.equals("Army Worm")) {
                            intImage[i] = R.drawable.armyworm;
                        } else if (current.equals("Bacterial Leaf Blight")) {
                            intImage[i] = R.drawable.bacterialblight;
                        } else if (current.equals("Black Bug")) {
                            intImage[i] = R.drawable.riceblackbug;
                        } else if (current.equals("Blast")) {
                            intImage[i] = R.drawable.riceblast;
                        } else if (current.equals("Ear Bug")) {
                            intImage[i] = R.drawable.riceearbug;
                        } else if (current.equals("Golden Apple Snail")) {
                            intImage[i] = R.drawable.goldenapplesnail;
                        } else if (current.equals("Green Leafhopper")) {
                            intImage[i] = R.drawable.greenleafhopper;
                        } else if (current.equals("Sheath Blight")) {
                            intImage[i] = R.drawable.sheathblight;
                        } else if (current.equals("Tungro")) {
                            intImage[i] = R.drawable.tungro;
                        }
                    } else {
                        // Change this into something blank
                        intImage[i] = R.drawable.roundbutton;
                    }

                }

                CustomListView customListView = new CustomListView(Results.this,
                        stringNames,
                        stringConfidence,
                        intImage);

                listView.setAdapter(customListView);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        if (stringNames[position].equals("Army Worm")) {
                            Intent intent = new Intent();
                            intent.setClass(Results.this, PestsDefinition.class);
                            startActivity(intent);
                        } else if (stringNames[position].equals("Bacterial Leaf Blight")) {
                            Intent intent = new Intent();
                            intent.setClass(Results.this, DiseasesDefinition.class);
                            startActivity(intent);
                        } else if (stringNames[position].equals("Black Bug")) {
                            Intent intent = new Intent();
                            intent.setClass(Results.this, PestsDefinition.PestDefinition4.class);
                            startActivity(intent);
                        } else if (stringNames[position].equals("Blast")) {
                            Intent intent = new Intent();
                            intent.setClass(Results.this, DiseasesDefinition.DiseaseDefinition2.class);
                            startActivity(intent);
                        } else if (stringNames[position].equals("Ear Bug")) {
                            Intent intent = new Intent();
                            intent.setClass(Results.this, PestsDefinition.PestDefinition5.class);
                            startActivity(intent);
                        } else if (stringNames[position].equals("Golden Apple Snail")) {
                            Intent intent = new Intent();
                            intent.setClass(Results.this, PestsDefinition.PestDefinition2.class);
                            startActivity(intent);
                        } else if (stringNames[position].equals("Green Leafhopper")) {
                            Intent intent = new Intent();
                            intent.setClass(Results.this, PestsDefinition.PestDefinition3.class);
                            startActivity(intent);
                        } else if (stringNames[position].equals("Sheath Blight")) {
                            Intent intent = new Intent();
                            intent.setClass(Results.this, DiseasesDefinition.DiseaseDefinition3.class);
                            startActivity(intent);
                        } else if (stringNames[position].equals("Tungro")) {
                            Intent intent = new Intent();
                            intent.setClass(Results.this, DiseasesDefinition.DiseaseDefinition4.class);
                            startActivity(intent);
                        }
                    }
                });


            }

            @Override
            public void onVideo(CameraKitVideo cameraKitVideo) {

            }
        });

        btnDetectObject2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Restart();
            }
        });

        btnDetectObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraView.captureImage();
                cameraView.setVisibility(v.INVISIBLE);
                imageViewResult.setVisibility(v.VISIBLE);
                listView.setVisibility(v.VISIBLE);
                btnDetectObject.setVisibility(View.INVISIBLE);
                btnDetectObjectCam.setVisibility(v.INVISIBLE);
                textView.setText("Results");
                btnDetectObject2.setVisibility(v.VISIBLE);

            }
        });

        btnDetectObjectCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cameraView.setVisibility(view.INVISIBLE);
                btnDetectObject.setVisibility(view.INVISIBLE);
                listView.setVisibility(view.VISIBLE);
                imageViewResult.setVisibility(view.VISIBLE);
                btnDetectObjectCam.setVisibility(view.INVISIBLE);
                btnDetectSelectImage.setVisibility(view.VISIBLE);
            }
        });

        btnDetectSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
                getIntent.setType("image/*");

                Intent pickIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");

                Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});

                startActivityForResult(chooserIntent, PICK_IMAGE);

                btnDetectObjectFromCam.setVisibility(view.VISIBLE);
            }
        });

        btnDetectObjectFromCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDetectObject2.setVisibility(view.VISIBLE);
                btnDetectObjectFromCam.setVisibility(view.INVISIBLE);
                btnDetectSelectImage.setVisibility(view.INVISIBLE);
                textView.setText("Results");

                Bitmap bitmap = ((BitmapDrawable) imageViewResult.getDrawable()).getBitmap();

                bitmap = Bitmap.createScaledBitmap(bitmap, INPUT_SIZE, INPUT_SIZE, false);
                imageViewResult.setImageBitmap(bitmap);

                final List<Classifier.Recognition> results = classifier.recognizeImage(bitmap);

                final ArrayList<HashMap<String, String>> listItems = new ArrayList<>();
                HashMap<String, String> listItemData;

                DatabaseHelper db = new DatabaseHelper(Results.this);

                for (int i = 0; i < results.size(); i++) {

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

                final String[] stringNames = new String[listItems.size()];
                String[] stringConfidence = new String[listItems.size()];
                Integer[] intImage = new Integer[listItems.size()];

                for (int i = 0; i < listItems.size(); i++) {
                    if (listItems.size() != 0) {
                        stringNames[i] = listItems.get(i).get("disease_name");
                        stringConfidence[i] = listItems.get(i).get("confidence");
                        String current = listItems.get(i).get("disease_name");

                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                        Date date = new Date();

                        String dateToday = dateFormat.format(date);

                        db.addInfo(new StatisticsInfo(stringNames[i], dateToday, stringConfidence[i]));

                        if (current.equals("Army Worm")) {
                            intImage[i] = R.drawable.armyworm;
                        } else if (current.equals("Bacterial Leaf Blight")) {
                            intImage[i] = R.drawable.bacterialblight;
                        } else if (current.equals("Black Bug")) {
                            intImage[i] = R.drawable.riceblackbug;
                        } else if (current.equals("Blast")) {
                            intImage[i] = R.drawable.riceblast;
                        } else if (current.equals("Ear Bug")) {
                            intImage[i] = R.drawable.riceearbug;
                        } else if (current.equals("Golden Apple Snail")) {
                            intImage[i] = R.drawable.goldenapplesnail;
                        } else if (current.equals("Green Leafhopper")) {
                            intImage[i] = R.drawable.greenleafhopper;
                        } else if (current.equals("Sheath Blight")) {
                            intImage[i] = R.drawable.sheathblight;
                        } else if (current.equals("Tungro")) {
                            intImage[i] = R.drawable.tungro;
                        }
                    } else {
                        // Change this into something blank
                        intImage[i] = R.drawable.roundbutton;
                    }

                }

                CustomListView customListView = new CustomListView(Results.this,
                        stringNames,
                        stringConfidence,
                        intImage);

                listView.setAdapter(customListView);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        if (stringNames[position].equals("Army Worm")) {
                            Intent intent = new Intent();
                            intent.setClass(Results.this, PestsDefinition.class);
                            startActivity(intent);
                        } else if (stringNames[position].equals("Bacterial Leaf Blight")) {
                            Intent intent = new Intent();
                            intent.setClass(Results.this, DiseasesDefinition.class);
                            startActivity(intent);
                        } else if (stringNames[position].equals("Black Bug")) {
                            Intent intent = new Intent();
                            intent.setClass(Results.this, PestsDefinition.PestDefinition4.class);
                            startActivity(intent);
                        } else if (stringNames[position].equals("Blast")) {
                            Intent intent = new Intent();
                            intent.setClass(Results.this, DiseasesDefinition.DiseaseDefinition2.class);
                            startActivity(intent);
                        } else if (stringNames[position].equals("Ear Bug")) {
                            Intent intent = new Intent();
                            intent.setClass(Results.this, PestsDefinition.PestDefinition5.class);
                            startActivity(intent);
                        } else if (stringNames[position].equals("Golden Apple Snail")) {
                            Intent intent = new Intent();
                            intent.setClass(Results.this, PestsDefinition.PestDefinition2.class);
                            startActivity(intent);
                        } else if (stringNames[position].equals("Green Leafhopper")) {
                            Intent intent = new Intent();
                            intent.setClass(Results.this, PestsDefinition.PestDefinition3.class);
                            startActivity(intent);
                        } else if (stringNames[position].equals("Sheath Blight")) {
                            Intent intent = new Intent();
                            intent.setClass(Results.this, DiseasesDefinition.DiseaseDefinition3.class);
                            startActivity(intent);
                        } else if (stringNames[position].equals("Tungro")) {
                            Intent intent = new Intent();
                            intent.setClass(Results.this, DiseasesDefinition.DiseaseDefinition4.class);
                            startActivity(intent);
                        }
                    }
                });

            }
        });

        initTensorFlowAndLoadModel();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            Uri imageUri = data.getData();

            InputStream inputStream;

            try {
                inputStream = getContentResolver().openInputStream(imageUri);

                Bitmap image = BitmapFactory.decodeStream(inputStream);

                imageViewResult.setImageBitmap(image);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void Restart() {
        this.recreate();
    }

    public void backActivity() {
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