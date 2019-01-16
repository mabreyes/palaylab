package com.example.rickydanobantonare.smartrice;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DiseasesDefinition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseases_definition);

        ViewPager viewPager = findViewById(R.id.viewpager);
        DiseasesViewPager diseasesViewPager = new DiseasesViewPager(this);
        viewPager.setAdapter(diseasesViewPager);

    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(DiseasesDefinition.this, Diseases.class );
        startActivity(intent);
    }
}
