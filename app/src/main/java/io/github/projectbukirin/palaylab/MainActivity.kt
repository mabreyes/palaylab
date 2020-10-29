package io.github.projectbukirin.palaylab

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private lateinit var logoutBtn: Button
    private lateinit var updatePass: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()

        if(auth.currentUser == null){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this, "Already logged in", Toast.LENGTH_LONG).show()
        }

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

        logoutBtn = findViewById(R.id.logout_btn)
        updatePass = findViewById(R.id.update_pass_btn)

        logoutBtn.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        updatePass.setOnClickListener{
            val intent = Intent(this, UpdatePassword::class.java)
            startActivity(intent)
        }

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