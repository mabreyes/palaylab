package xyz.marcreyes.palaylab.app.about

import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import xyz.marcreyes.palaylab.app.authentication.LoginActivity
import xyz.marcreyes.palaylab.app.R
import xyz.marcreyes.palaylab.app.authentication.UpdatePassword

class About : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private lateinit var logoutBtn: Button
    private lateinit var updatePass: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()

        if (auth.currentUser == null) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
        }

        setContentView(R.layout.activity_about)
        setSupportActionBar(findViewById(R.id.toolbar_about))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "About"

        val textView = findViewById<View>(R.id.link) as TextView
        textView.movementMethod = LinkMovementMethod.getInstance()

        logoutBtn = findViewById(R.id.logout_btn)
        updatePass = findViewById(R.id.update_pass_btn)

        logoutBtn.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        updatePass.setOnClickListener {
            val intent = Intent(this, UpdatePassword::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.settings_actionbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_settings -> {
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}