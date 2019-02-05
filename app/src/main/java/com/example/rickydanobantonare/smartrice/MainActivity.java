package com.example.rickydanobantonare.smartrice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diseaseActivity();
            }
        });
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pestActivity();
            }
        });
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultsActivity();
            }
        });
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutActivity();
            }
        });

        DatabaseHelper db = new DatabaseHelper(this);

        List<StatisticsInfo> list = db.getAllInfo();

        TextView textResult = (TextView) findViewById(R.id.textResult);

        textResult.setText(db.getAllInfo().toString());



    }

    public void diseaseActivity(){
        Intent intent = new Intent(MainActivity.this, Diseases.class);
        startActivity(intent);
    }
    public void pestActivity(){
        Intent intent = new Intent(MainActivity.this, Pest.class);
        startActivity(intent);
    }
    public void resultsActivity(){
        Intent intent = new Intent(MainActivity.this, Results.class);
        startActivity(intent);
    }
    public void aboutActivity(){
        Intent intent = new Intent(MainActivity.this, About.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }

}
