package io.github.projectbukirin.palaylab

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var dbReference: DatabaseReference
    private lateinit var firebaseDatabase: FirebaseDatabase
    private var userId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()

        if(auth.currentUser == null){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Already logged in", Toast.LENGTH_LONG).show()
        }

        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar_main))

        supportActionBar?.title = "Home"

        val button = findViewById<View>(R.id.button) as Button
        button.setOnClickListener { diseaseActivity() }
        val button1 = findViewById<View>(R.id.button1) as Button
        button1.setOnClickListener { pestActivity() }
        val button2 = findViewById<View>(R.id.button2) as Button
        button2.setOnClickListener { resultsActivity() }
        val button4 = findViewById<View>(R.id.button4) as Button
        button4.setOnClickListener { statisticsActivity() }

//        Helper code snippets. Don't remove this for now
//
//        DatabaseHelper db = new DatabaseHelper(this);
//
//        List<StatisticsInfo> list = db.getAllInfo();
//
//        db.deleteInfo(list.get(0));
//
//        *for (int i=0; i<4; i++) {
//            db.deleteInfo(list.get(i));
//        }

//        var textResult = findViewById<View>(R.id.textResult) as TextView;

//        textResult.setText(db.getAllInfo().toString());
//
//        textResult.setText(String.valueOf(db.countThisWeek("Tungro")));
//
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

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_settings -> {
            aboutActivity()
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.settings_actionbar, menu)
        return true
    }



    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
    }
}