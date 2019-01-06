package com.example.rickydanobantonare.smartrice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class About extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        textView = (TextView) findViewById(R.id.about);
        String text = "";
        textView.setText(text);
        textView.setMovementMethod(new ScrollingMovementMethod());

        ImageButton androidImageButton = (ImageButton) findViewById(R.id.imageButton3);
        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backActivity();
            }
        });


    }

    public void backActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed(){

    }
}
