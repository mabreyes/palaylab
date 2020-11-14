package io.github.projectbukirin.palaylab

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import org.eazegraph.lib.charts.PieChart
import org.eazegraph.lib.models.PieModel

// Import the required libraries
class Statistics : AppCompatActivity() {
    // Create the object of TextView
    // and PieChart class
    var tvR: TextView? = null
    var tvPython: TextView? = null
    var tvCPP: TextView? = null
    var tvJava: TextView? = null
    var pieChart: PieChart? = null
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

        // Link those objects with their
        // respective id's that
        // we have given in .XML file
        tvR = findViewById(R.id.tvR)
        tvPython = findViewById(R.id.tvPython)
        tvCPP = findViewById(R.id.tvCPP)
        tvJava = findViewById(R.id.tvJava)
        pieChart = findViewById(R.id.piechart)

        // Creating a method setData()
        // to set the text in text view and pie chart
        setData()
    }

    private fun setData() {

        // Set the percentage of language used
        tvR!!.text = Integer.toString(40)
        tvPython!!.text = Integer.toString(30)
        tvCPP!!.text = Integer.toString(5)
        tvJava!!.text = Integer.toString(25)

        // Set the data and color to the pie chart
        pieChart!!.addPieSlice(
                PieModel(
                        "R", tvR!!.text.toString().toInt().toFloat(),
                        Color.parseColor("#FFA726")))
        pieChart!!.addPieSlice(
                PieModel(
                        "Python", tvPython!!.text.toString().toInt().toFloat(),
                        Color.parseColor("#66BB6A")))
        pieChart!!.addPieSlice(
                PieModel(
                        "C++", tvCPP!!.text.toString().toInt().toFloat(),
                        Color.parseColor("#EF5350")))
        pieChart!!.addPieSlice(
                PieModel(
                        "Java", tvJava!!.text.toString().toInt().toFloat(),
                        Color.parseColor("#29B6F6")))

        // To animate the pie chart
        pieChart!!.startAnimation()
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
}