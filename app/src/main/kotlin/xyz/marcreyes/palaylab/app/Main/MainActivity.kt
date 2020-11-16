package xyz.marcreyes.palaylab.app.Main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import xyz.marcreyes.palaylab.app.About.About
import xyz.marcreyes.palaylab.app.Authentication.LoginActivity
import xyz.marcreyes.palaylab.app.Disease.Diseases
import xyz.marcreyes.palaylab.app.Pest.Pest
import xyz.marcreyes.palaylab.app.R
import xyz.marcreyes.palaylab.app.Prediction.Results
import xyz.marcreyes.palaylab.app.Statistics.Statistics


class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()

        if (auth.currentUser == null) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
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