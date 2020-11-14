package io.github.projectbukirin.palaylab

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.HorizontalBarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*
import java.util.*


class Statistics : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        val mBarChart = findViewById<View>(R.id.id_horizontal_barchart) as HorizontalBarChart

        setSupportActionBar(findViewById(R.id.toolbar_statistics))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Statistics"

        val barEntries = ArrayList<BarEntry>()
        barEntries.add(BarEntry(1f, 5f))
        barEntries.add(BarEntry(2f, 10f))
        barEntries.add(BarEntry(3f, 13f))
        barEntries.add(BarEntry(4f, 8f))

        val xAxisName = ArrayList<String>()
        xAxisName.add("Name 1")
        xAxisName.add("Name 2")
        xAxisName.add("Name 3")
        xAxisName.add("Name 4")

        val dBarChart = DisplayChart()
        dBarChart.barChart(mBarChart, barEntries, xAxisName)

        val mPieChart: PieChart = findViewById(R.id.pie_chart)

        val sessDataPie1: ArrayList<PieEntry> = ArrayList()
        sessDataPie1.add(PieEntry(2f, "Data 1"))
        sessDataPie1.add(PieEntry(7f, "Data 2"))
        sessDataPie1.add(PieEntry(5f, "Data 3"))

        val dPieChart = DisplayChart()
        dPieChart.pieChart(mPieChart, sessDataPie1)
    }


    fun Restart() {
        recreate()
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_settings -> {
            val intent = Intent(this, About::class.java)
            startActivity(intent)
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


    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}