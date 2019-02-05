package com.example.rickydanobantonare.smartrice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Statistics extends AppCompatActivity {

    TextView blbThisWeek,
            blbTotalDetections,
            rbThisWeek,
            rbTotalDetections,
            sbThisWeek,
            sbTotalDetections,
            tunThisWeek,
            tunTotalDetections,
            awThisWeek,
            awTotalDetections,
            gasThisWeek,
            gasTotalDetections,
            glhThisWeek,
            glhTotalDetections,
            rbbThisWeek,
            rbbTotalDetections,
            rebThisWeek,
            rebTotalDetections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        ImageButton androidImageButton = (ImageButton) findViewById(R.id.imageButton3);
        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backActivity();
            }
        });

        DatabaseHelper db = new DatabaseHelper(this);

        int armyWormData = db.countInfo("Army Worm");
        int bacterialLeafBlightData = db.countInfo("Bacterial Leaf Blight");
        int blackBugData = db.countInfo("Black Bug");
        int blastData = db.countInfo("Blast");
        int earBugData = db.countInfo("Ear Bug");
        int goldenAppleSnailData = db.countInfo("Golden Apple Snail");
        int greenLeafhopperData = db.countInfo("Green Leafhopper");
        int sheathBlightData = db.countInfo("Sheath Blight");
        int tungroData = db.countInfo("Tungro");

        int armyWormDataTW = db.countThisWeek("Army Worm");
        int bacterialLeafBlightDataTW = db.countThisWeek("Bacterial Leaf Blight");
        int blackBugDataTW = db.countThisWeek("Black Bug");
        int blastDataTW = db.countThisWeek("Blast");
        int earBugDataTW = db.countThisWeek("Ear Bug");
        int goldenAppleSnailDataTW = db.countThisWeek("Golden Apple Snail");
        int greenLeafhopperDataTW = db.countThisWeek("Green Leafhopper");
        int sheathBlightDataTW = db.countThisWeek("Sheath Blight");
        int tungroDataTW = db.countThisWeek("Tungro");

        blbThisWeek = (TextView) findViewById(R.id.blbThisWeek);
        blbTotalDetections = (TextView) findViewById(R.id.blbTotalDetections);
        rbThisWeek = (TextView) findViewById(R.id.rbThisWeek);
        rbTotalDetections = (TextView) findViewById(R.id.rbTotalDetections);
        sbThisWeek = (TextView) findViewById(R.id.sbThisWeek);
        sbTotalDetections = (TextView) findViewById(R.id.sbTotalDetections);
        tunThisWeek = (TextView) findViewById(R.id.tunThisWeek);
        tunTotalDetections = (TextView) findViewById(R.id.tunTotalDetections);

        awThisWeek = (TextView) findViewById(R.id.awThisWeek);
        awTotalDetections = (TextView) findViewById(R.id.awTotalDetections);
        gasThisWeek = (TextView) findViewById(R.id.gasThisWeek);
        gasTotalDetections = (TextView) findViewById(R.id.gasTotalDetections);
        glhThisWeek = (TextView) findViewById(R.id.glhThisWeek);
        glhTotalDetections = (TextView) findViewById(R.id.glhTotalDetections);
        rbbThisWeek = (TextView) findViewById(R.id.rbbThisWeek);
        rbbTotalDetections = (TextView) findViewById(R.id.rbbTotalDetections);
        rebThisWeek = (TextView) findViewById(R.id.rebThisWeek);
        rebTotalDetections = (TextView) findViewById(R.id.rebTotalDetections);

        blbThisWeek.setText(String.valueOf(bacterialLeafBlightDataTW));
        blbTotalDetections.setText(String.valueOf(bacterialLeafBlightData));
        rbThisWeek.setText(String.valueOf(blastDataTW));
        rbTotalDetections.setText(String.valueOf(blastData));
        sbThisWeek.setText(String.valueOf(sheathBlightDataTW));
        sbTotalDetections.setText(String.valueOf(sheathBlightData));
        tunThisWeek.setText(String.valueOf(tungroDataTW));
        tunTotalDetections.setText(String.valueOf(tungroData));

        awThisWeek.setText(String.valueOf(armyWormDataTW));
        awTotalDetections.setText(String.valueOf(armyWormData));
        gasThisWeek.setText(String.valueOf(goldenAppleSnailDataTW));
        gasTotalDetections.setText(String.valueOf(goldenAppleSnailData));
        glhThisWeek.setText(String.valueOf(greenLeafhopperDataTW));
        glhTotalDetections.setText(String.valueOf(greenLeafhopperData));
        rbbThisWeek.setText(String.valueOf(blackBugDataTW));
        rbbTotalDetections.setText(String.valueOf(blackBugData));
        rebThisWeek.setText(String.valueOf(earBugDataTW));
        rebTotalDetections.setText(String.valueOf(earBugData));

        BarChart chart = findViewById(R.id.barchart);

        ArrayList DetectionItem = new ArrayList();

        DetectionItem.add(new BarEntry(armyWormData, 0));
        DetectionItem.add(new BarEntry(bacterialLeafBlightData, 1));
        DetectionItem.add(new BarEntry(blackBugData, 2));
        DetectionItem.add(new BarEntry(blastData, 3));
        DetectionItem.add(new BarEntry(earBugData, 4));
        DetectionItem.add(new BarEntry(goldenAppleSnailData, 5));
        DetectionItem.add(new BarEntry(greenLeafhopperData, 6));
        DetectionItem.add(new BarEntry(sheathBlightData, 7));
        DetectionItem.add(new BarEntry(tungroData, 8));

        ArrayList DetectionItemLabel = new ArrayList();

        DetectionItemLabel.add("Army Worm");
        DetectionItemLabel.add("BLB");
        DetectionItemLabel.add("RBB");
        DetectionItemLabel.add("Blast");
        DetectionItemLabel.add("Ear Bug");
        DetectionItemLabel.add("GAS");
        DetectionItemLabel.add("GLH");
        DetectionItemLabel.add("Sheath Blight");
        DetectionItemLabel.add("Tungro");

        ArrayList DetectionDiseases = new ArrayList();

        DetectionDiseases.add(new BarEntry(bacterialLeafBlightData, 1));
        DetectionDiseases.add(new BarEntry(blastData, 2));
        DetectionDiseases.add(new BarEntry(sheathBlightData, 3));
        DetectionDiseases.add(new BarEntry(tungroData, 4));

        ArrayList DetectionDiseasesItemLabel = new ArrayList();

        DetectionDiseasesItemLabel.add("BLB");
        DetectionDiseasesItemLabel.add("Blast");
        DetectionDiseasesItemLabel.add("Sheath Blight");
        DetectionDiseasesItemLabel.add("Tungro");

        BarDataSet bardataset = new BarDataSet(DetectionItem, "Total Detections");
        chart.animateY(1000);
        BarData data = new BarData(DetectionItemLabel, bardataset);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.setData(data);

        PieChart diseasesPieChart = findViewById(R.id.piechart);

        PieDataSet diseasesDataset = new PieDataSet(DetectionDiseases, "Diseases");

        PieData dataDiseasesDataset = new PieData(DetectionDiseasesItemLabel, diseasesDataset);
        diseasesPieChart.setData(dataDiseasesDataset);
        diseasesDataset.setColors(ColorTemplate.COLORFUL_COLORS);
        diseasesPieChart.animateXY(1000, 1000);

        diseasesPieChart.setUsePercentValues(true);

        ArrayList DetectionPests = new ArrayList();

        DetectionPests.add(new BarEntry(armyWormData, 1));
        DetectionPests.add(new BarEntry(goldenAppleSnailData, 2));
        DetectionPests.add(new BarEntry(greenLeafhopperData, 3));
        DetectionPests.add(new BarEntry(blackBugData, 4));
        DetectionPests.add(new BarEntry(tungroData, 5));

        ArrayList DetectionPestsItemLabel = new ArrayList();

        DetectionPestsItemLabel.add("Army Worm");
        DetectionPestsItemLabel.add("GAS");
        DetectionPestsItemLabel.add("GLH");
        DetectionPestsItemLabel.add("RBB");
        DetectionPestsItemLabel.add("Tungro");

        PieChart pestsPieChart = findViewById(R.id.piechart2);

        PieDataSet pestsDataset = new PieDataSet(DetectionPests, "Pests");

        PieData dataPestsDataset = new PieData(DetectionPestsItemLabel, pestsDataset);
        pestsPieChart.setData(dataPestsDataset);
        pestsDataset.setColors(ColorTemplate.COLORFUL_COLORS);
        pestsPieChart.animateXY(1000, 1000);

        pestsPieChart.setUsePercentValues(true);


    }

    public void backActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Statistics.this, MainActivity.class);
        startActivity(intent);
    }
}
