package com.example.rickydanobantonare.smartrice;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
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
        SpannableString s1 = new SpannableString("Developers\n");
        SpannableString s2 = new SpannableString("Ricky D Bantonare\nMarc Anthony B Reyes\nPaul Arnold M Simbajon\n\n");
        SpannableString s3 = new SpannableString("Adviser\n");
        SpannableString s4 = new SpannableString("Cristina Amor Cajilla, MIT\n");

        int flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
        s1.setSpan(new StyleSpan(Typeface.BOLD), 0, s1.length(), flag);
        s1.setSpan(new RelativeSizeSpan(1.5f), 0, s1.length(), flag);
        s2.setSpan(new StyleSpan(Typeface.BOLD), 0, s2.length(), flag);
        s2.setSpan(new RelativeSizeSpan(0.7f), 0, s2.length(), flag);
        s3.setSpan(new StyleSpan(Typeface.BOLD), 0, s3.length(), flag);
        s3.setSpan(new RelativeSizeSpan(1.5f), 0, s3.length(), flag);
        s4.setSpan(new StyleSpan(Typeface.BOLD), 0, s4.length(), flag);
        s4.setSpan(new RelativeSizeSpan(0.7f), 0, s4.length(), flag);


        SpannableStringBuilder builder = new SpannableStringBuilder();
        builder.append(s1);
        builder.append(s2);
        builder.append(s3);
        builder.append(s4);
        textView.setText(builder);
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
        Intent intent = new Intent(About.this, MainActivity.class );
        startActivity(intent);
    }
}
