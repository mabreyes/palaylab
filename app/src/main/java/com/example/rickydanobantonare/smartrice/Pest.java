package com.example.rickydanobantonare.smartrice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

public class Pest extends AppCompatActivity {
    ListView list;
    String[] pestename = {"Army Worm","Golden Apple Snail","Green Leafhopper","Rice Black Bug", "Rice Ear Bug"};
    String[] desc= {"Pest","Pest","Pest","Pest","Pest"};
    Integer[] imgid={R.drawable.armyworm,R.drawable.goldenapplesnail,R.drawable.greenleafhopper,R.drawable.riceblackbug, R.drawable.riceearbug};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pest);

        list = (ListView) findViewById(R.id.pestitem);
        CustomListView customListview=new CustomListView(this, pestename,desc,imgid);
        list.setAdapter(customListview);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
                    case 0:
                        Intent intent = new Intent();
                        intent.setClass(Pest.this, PestsDefinition.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent();
                        intent1.setClass(Pest.this, PestsDefinition.PestDefinition2.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent();
                        intent2.setClass(Pest.this, PestsDefinition.PestDefinition3.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent();
                        intent3.setClass(Pest.this, PestsDefinition.PestDefinition4.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent();
                        intent4.setClass(Pest.this, PestsDefinition.PestDefinition5.class);
                        startActivity(intent4);
                        break;
                }
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
        Intent intent = new Intent(Pest.this, MainActivity.class );
        startActivity(intent);
    }
}
