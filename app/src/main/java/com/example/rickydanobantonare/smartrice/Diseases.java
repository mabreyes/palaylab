package com.example.rickydanobantonare.smartrice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

public class Diseases extends AppCompatActivity {

    ListView list;
    String[] diseasename = {"Bacterial Blight","Rice Blast","Sheath Blight","Tungro"};
    String[] desc= {"Disease","Disease","Disease","Disease"};
    Integer[] imgid={R.drawable.bacterialblight,R.drawable.riceblast,R.drawable.sheathblight,R.drawable.tungro};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseases);

        list = (ListView) findViewById(R.id.disease_list);
        CustomListview customListview=new CustomListview(this, diseasename,desc,imgid);
        list.setAdapter(customListview);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent();
                intent.setClass(Diseases.this, DiseasesDefinition.class);
                startActivity(intent);
            }
        });



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
        Intent intent = new Intent(Diseases.this, MainActivity.class );
        startActivity(intent);
    }
}
