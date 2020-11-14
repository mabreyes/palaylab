package io.github.projectbukirin.palaylab

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth


// Import the required libraries
class Statistics : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)
        auth = FirebaseAuth.getInstance()

        if(auth.currentUser == null){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Already logged in", Toast.LENGTH_LONG).show()
        }

        setSupportActionBar(findViewById(R.id.toolbar_statistics))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.title = "Statistics"

        val viewPager = findViewById<View>(R.id.viewPager) as ViewPager
        val tabLayout = findViewById<View>(R.id.tabLayout) as TabLayout
        val adapter = TabAdapter(supportFragmentManager)
        adapter.addFragment(DiseaseStatisticsFragment(), "Diseases")
        adapter.addFragment(PestStatisticsFragment(), "Pests")
        viewPager.setAdapter(adapter)
        tabLayout.setupWithViewPager(viewPager)
    }


    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_settings -> {
            val intent = Intent(this, About::class.java)
            startActivity(intent)
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

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}