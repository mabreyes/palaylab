package io.github.projectbukirin.palaylab

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<View>(R.id.button) as Button
        button.setOnClickListener { diseaseActivity() }
        val button1 = findViewById<View>(R.id.button1) as Button
        button1.setOnClickListener { pestActivity() }
        val button2 = findViewById<View>(R.id.button2) as Button
        button2.setOnClickListener { resultsActivity() }
        val button4 = findViewById<View>(R.id.button4) as Button
        button4.setOnClickListener { statisticsActivity() }
        val imageButton = findViewById<View>(R.id.about) as ImageButton
        imageButton.setOnClickListener { aboutActivity() }


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

    fun diseaseActivity() {
        val intent = Intent(this@MainActivity, Diseases::class.java)
        startActivity(intent)
    }

    fun pestActivity() {
        val intent = Intent(this@MainActivity, Pest::class.java)
        startActivity(intent)
    }

    fun resultsActivity() {
        val intent = Intent(this@MainActivity, Results::class.java)
        startActivity(intent)
    }

    fun statisticsActivity() {
        val intent = Intent(this@MainActivity, Statistics::class.java)
        startActivity(intent)
    }

    fun aboutActivity() {
        val intent = Intent(this@MainActivity, About::class.java)
        startActivity(intent)
    }

    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
    }
}