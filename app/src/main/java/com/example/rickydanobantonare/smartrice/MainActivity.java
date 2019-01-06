package com.example.rickydanobantonare.smartrice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

}
