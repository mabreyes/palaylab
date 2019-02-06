package com.example.rickydanobantonare.smartrice;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Statistics extends AppCompatActivity {

    Button btnClearData;

    TextView blbThisWeek, blbTotalDetections, rbThisWeek, rbTotalDetections, sbThisWeek,
            sbTotalDetections, tunThisWeek, tunTotalDetections, awThisWeek, awTotalDetections,
            gasThisWeek, gasTotalDetections, glhThisWeek, glhTotalDetections, rbbThisWeek,
            rbbTotalDetections, rebThisWeek, rebTotalDetections;

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

        final DatabaseHelper db = new DatabaseHelper(this);

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
        bardataset.setColors(ColorTemplate.PASTEL_COLORS);
        chart.setData(data);
        chart.setDescription(null);

        PieChart diseasesPieChart = findViewById(R.id.piechart);

        PieDataSet diseasesDataset = new PieDataSet(DetectionDiseases, "Diseases");

        PieData dataDiseasesDataset = new PieData(DetectionDiseasesItemLabel, diseasesDataset);
        diseasesPieChart.setData(dataDiseasesDataset);
        diseasesDataset.setColors(ColorTemplate.PASTEL_COLORS);
        diseasesPieChart.animateXY(1000, 1000);

        diseasesPieChart.setUsePercentValues(true);
        diseasesPieChart.setDescription(null);

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
        pestsDataset.setColors(ColorTemplate.PASTEL_COLORS);
        pestsPieChart.animateXY(1000, 1000);

        pestsPieChart.setUsePercentValues(true);
        pestsPieChart.setDescription(null);

        ArrayList DetectionThisWeekItem = new ArrayList();

        DetectionThisWeekItem.add(new BarEntry(armyWormDataTW, 0));
        DetectionThisWeekItem.add(new BarEntry(bacterialLeafBlightDataTW, 1));
        DetectionThisWeekItem.add(new BarEntry(blackBugDataTW, 2));
        DetectionThisWeekItem.add(new BarEntry(blastDataTW, 3));
        DetectionThisWeekItem.add(new BarEntry(earBugDataTW, 4));
        DetectionThisWeekItem.add(new BarEntry(goldenAppleSnailDataTW, 5));
        DetectionThisWeekItem.add(new BarEntry(greenLeafhopperDataTW, 6));
        DetectionThisWeekItem.add(new BarEntry(sheathBlightDataTW, 7));
        DetectionThisWeekItem.add(new BarEntry(tungroDataTW, 8));

        ArrayList DetectionThisWeekItemLabel = new ArrayList();

        DetectionThisWeekItemLabel.add("Army Worm");
        DetectionThisWeekItemLabel.add("BLB");
        DetectionThisWeekItemLabel.add("RBB");
        DetectionThisWeekItemLabel.add("Blast");
        DetectionThisWeekItemLabel.add("Ear Bug");
        DetectionThisWeekItemLabel.add("GAS");
        DetectionThisWeekItemLabel.add("GLH");
        DetectionThisWeekItemLabel.add("Sheath Blight");
        DetectionThisWeekItemLabel.add("Tungro");

        BarChart barChart = findViewById(R.id.thisWeekChart);

        BarDataSet barDataset = new BarDataSet(DetectionThisWeekItem, "Total Detections");
        barChart.animateY(1000);
        BarData barDatasetData = new BarData(DetectionThisWeekItemLabel, barDataset);
        barDataset.setColors(ColorTemplate.PASTEL_COLORS);
        barChart.setData(barDatasetData);
        barChart.setDescription(null);

        btnClearData = (Button) findViewById(R.id.btnClearData);

        btnClearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Statistics.this);
                alertDialogBuilder.setMessage("Are you sure you wanted to clear the data? " +
                        "After deleting, you could no longer retrieve it back.");
                alertDialogBuilder.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                List<StatisticsInfo> dataList = db.getAllInfo();

                                int dataCount = db.countAllData();

                                for (int j=0; j<dataCount; j++) {
                                    db.deleteInfo(dataList.get(j));
                                }

                                Toast.makeText(Statistics.this, "All data were cleared",
                                        Toast.LENGTH_LONG).show();

                                Restart();
                            }
                        });

                alertDialogBuilder.setNegativeButton("no",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Restart();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

    }

    public void Restart() {
        this.recreate();
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
