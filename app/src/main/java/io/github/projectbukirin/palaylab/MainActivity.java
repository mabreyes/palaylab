package io.github.projectbukirin.palaylab;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

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
                statisticsActivity();
            }
        });
        ImageButton imageButton = (ImageButton) findViewById(R.id.about);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aboutActivity();
            }
        });


        /* Helper code snippets. Don't remove this for now

        DatabaseHelper db = new DatabaseHelper(this);

        List<StatisticsInfo> list = db.getAllInfo();

        db.deleteInfo(list.get(0));

        *for (int i=0; i<4; i++) {
            db.deleteInfo(list.get(i));
        }

        TextView textResult = (TextView) findViewById(R.id.textResult);

        textResult.setText(db.getAllInfo().toString());

        textResult.setText(String.valueOf(db.countThisWeek("Tungro")));
        */

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
    public void statisticsActivity(){
        Intent intent = new Intent(MainActivity.this, Statistics.class);
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
