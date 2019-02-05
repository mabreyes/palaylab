package com.example.rickydanobantonare.smartrice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

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

        GraphView graph = (GraphView) findViewById(R.id.graph);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[]{
                new DataPoint(1, armyWormData),
                new DataPoint(2, bacterialLeafBlightData),
                new DataPoint(3, blackBugData),
                new DataPoint(4, blastData),
                new DataPoint(5, earBugData),
                new DataPoint(6, goldenAppleSnailData),
                new DataPoint(7, greenLeafhopperData),
                new DataPoint(8, sheathBlightData),
                new DataPoint(9, tungroData),
        });
        graph.addSeries(series);

        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
        staticLabelsFormatter.setHorizontalLabels(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"});
        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

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
