package io.github.projectbukirin.palaylab

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate
import java.util.*

class Statistics : AppCompatActivity() {
    var btnClearData: Button? = null
    var blbThisWeek: TextView? = null
    var blbTotalDetections: TextView? = null
    var rbThisWeek: TextView? = null
    var rbTotalDetections: TextView? = null
    var sbThisWeek: TextView? = null
    var sbTotalDetections: TextView? = null
    var tunThisWeek: TextView? = null
    var tunTotalDetections: TextView? = null
    var awThisWeek: TextView? = null
    var awTotalDetections: TextView? = null
    var gasThisWeek: TextView? = null
    var gasTotalDetections: TextView? = null
    var glhThisWeek: TextView? = null
    var glhTotalDetections: TextView? = null
    var rbbThisWeek: TextView? = null
    var rbbTotalDetections: TextView? = null
    var rebThisWeek: TextView? = null
    var rebTotalDetections: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        setSupportActionBar(findViewById(R.id.toolbar_statistics))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Statistics"

        val db = DatabaseHelper(this)
        val armyWormData = db.countInfo("Army Worm")
        val bacterialLeafBlightData = db.countInfo("Bacterial Leaf Blight")
        val blackBugData = db.countInfo("Black Bug")
        val blastData = db.countInfo("Blast")
        val earBugData = db.countInfo("Ear Bug")
        val goldenAppleSnailData = db.countInfo("Golden Apple Snail")
        val greenLeafhopperData = db.countInfo("Green Leafhopper")
        val sheathBlightData = db.countInfo("Sheath Blight")
        val tungroData = db.countInfo("Tungro")
        val armyWormDataTW = db.countThisWeek("Army Worm")
        val bacterialLeafBlightDataTW = db.countThisWeek("Bacterial Leaf Blight")
        val blackBugDataTW = db.countThisWeek("Black Bug")
        val blastDataTW = db.countThisWeek("Blast")
        val earBugDataTW = db.countThisWeek("Ear Bug")
        val goldenAppleSnailDataTW = db.countThisWeek("Golden Apple Snail")
        val greenLeafhopperDataTW = db.countThisWeek("Green Leafhopper")
        val sheathBlightDataTW = db.countThisWeek("Sheath Blight")
        val tungroDataTW = db.countThisWeek("Tungro")
        blbThisWeek = findViewById<View>(R.id.blbThisWeek) as TextView
        blbTotalDetections = findViewById<View>(R.id.blbTotalDetections) as TextView
        rbThisWeek = findViewById<View>(R.id.rbThisWeek) as TextView
        rbTotalDetections = findViewById<View>(R.id.rbTotalDetections) as TextView
        sbThisWeek = findViewById<View>(R.id.sbThisWeek) as TextView
        sbTotalDetections = findViewById<View>(R.id.sbTotalDetections) as TextView
        tunThisWeek = findViewById<View>(R.id.tunThisWeek) as TextView
        tunTotalDetections = findViewById<View>(R.id.tunTotalDetections) as TextView
        awThisWeek = findViewById<View>(R.id.awThisWeek) as TextView
        awTotalDetections = findViewById<View>(R.id.awTotalDetections) as TextView
        gasThisWeek = findViewById<View>(R.id.gasThisWeek) as TextView
        gasTotalDetections = findViewById<View>(R.id.gasTotalDetections) as TextView
        glhThisWeek = findViewById<View>(R.id.glhThisWeek) as TextView
        glhTotalDetections = findViewById<View>(R.id.glhTotalDetections) as TextView
        rbbThisWeek = findViewById<View>(R.id.rbbThisWeek) as TextView
        rbbTotalDetections = findViewById<View>(R.id.rbbTotalDetections) as TextView
        rebThisWeek = findViewById<View>(R.id.rebThisWeek) as TextView
        rebTotalDetections = findViewById<View>(R.id.rebTotalDetections) as TextView
        blbThisWeek!!.text = bacterialLeafBlightDataTW.toString()
        blbTotalDetections!!.text = bacterialLeafBlightData.toString()
        rbThisWeek!!.text = blastDataTW.toString()
        rbTotalDetections!!.text = blastData.toString()
        sbThisWeek!!.text = sheathBlightDataTW.toString()
        sbTotalDetections!!.text = sheathBlightData.toString()
        tunThisWeek!!.text = tungroDataTW.toString()
        tunTotalDetections!!.text = tungroData.toString()
        awThisWeek!!.text = armyWormDataTW.toString()
        awTotalDetections!!.text = armyWormData.toString()
        gasThisWeek!!.text = goldenAppleSnailDataTW.toString()
        gasTotalDetections!!.text = goldenAppleSnailData.toString()
        glhThisWeek!!.text = greenLeafhopperDataTW.toString()
        glhTotalDetections!!.text = greenLeafhopperData.toString()
        rbbThisWeek!!.text = blackBugDataTW.toString()
        rbbTotalDetections!!.text = blackBugData.toString()
        rebThisWeek!!.text = earBugDataTW.toString()
        rebTotalDetections!!.text = earBugData.toString()
        val chart = findViewById<BarChart>(R.id.barchart)
        val detectionItem = ArrayList<BarEntry>()
        detectionItem.add(BarEntry(armyWormData.toFloat(), 0))
        detectionItem.add(BarEntry(bacterialLeafBlightData.toFloat(), 1))
        detectionItem.add(BarEntry(blackBugData.toFloat(), 2))
        detectionItem.add(BarEntry(blastData.toFloat(), 3))
        detectionItem.add(BarEntry(earBugData.toFloat(), 4))
        detectionItem.add(BarEntry(goldenAppleSnailData.toFloat(), 5))
        detectionItem.add(BarEntry(greenLeafhopperData.toFloat(), 6))
        detectionItem.add(BarEntry(sheathBlightData.toFloat(), 7))
        detectionItem.add(BarEntry(tungroData.toFloat(), 8))
        val detectionItemLabel = ArrayList<String>()
        detectionItemLabel.add("Army Worm")
        detectionItemLabel.add("BLB")
        detectionItemLabel.add("RBB")
        detectionItemLabel.add("Blast")
        detectionItemLabel.add("Ear Bug")
        detectionItemLabel.add("GAS")
        detectionItemLabel.add("GLH")
        detectionItemLabel.add("Sheath Blight")
        detectionItemLabel.add("Tungro")
        val detectionDiseases = ArrayList<BarEntry>()
        detectionDiseases.add(BarEntry(bacterialLeafBlightData.toFloat(), 1))
        detectionDiseases.add(BarEntry(blastData.toFloat(), 2))
        detectionDiseases.add(BarEntry(sheathBlightData.toFloat(), 3))
        detectionDiseases.add(BarEntry(tungroData.toFloat(), 4))
        val detectionDiseasesItemLabel = ArrayList<String>()
        detectionDiseasesItemLabel.add("BLB")
        detectionDiseasesItemLabel.add("Blast")
        detectionDiseasesItemLabel.add("Sheath Blight")
        detectionDiseasesItemLabel.add("Tungro")
        val bardataset = BarDataSet(detectionItem, "Total Detections")
        chart.animateY(1000)
        val data = BarData(detectionItemLabel, bardataset)
        bardataset.setColors(ColorTemplate.PASTEL_COLORS)
        chart.data = data
        chart.setDescription(null)
        val diseasesPieChart = findViewById<PieChart>(R.id.piechart)
        val diseasesDataset = PieDataSet(detectionDiseases as List<Entry>?, "Diseases")
        val dataDiseasesDataset = PieData(detectionDiseasesItemLabel, diseasesDataset)
        diseasesPieChart.data = dataDiseasesDataset
        diseasesDataset.setColors(ColorTemplate.PASTEL_COLORS)
        diseasesPieChart.animateXY(1000, 1000)
        diseasesPieChart.setUsePercentValues(true)
        diseasesPieChart.setDescription(null)
        val detectionPests = ArrayList<BarEntry>()
        detectionPests.add(BarEntry(armyWormData.toFloat(), 1))
        detectionPests.add(BarEntry(goldenAppleSnailData.toFloat(), 2))
        detectionPests.add(BarEntry(greenLeafhopperData.toFloat(), 3))
        detectionPests.add(BarEntry(blackBugData.toFloat(), 4))
        detectionPests.add(BarEntry(tungroData.toFloat(), 5))
        val detectionPestsItemLabel = ArrayList<String>()
        detectionPestsItemLabel.add("Army Worm")
        detectionPestsItemLabel.add("GAS")
        detectionPestsItemLabel.add("GLH")
        detectionPestsItemLabel.add("RBB")
        detectionPestsItemLabel.add("Tungro")
        val pestsPieChart = findViewById<PieChart>(R.id.piechart2)
        val pestsDataset = PieDataSet(detectionPests as List<Entry>?, "Pests")
        val dataPestsDataset = PieData(detectionPestsItemLabel, pestsDataset)
        pestsPieChart.data = dataPestsDataset
        pestsDataset.setColors(ColorTemplate.PASTEL_COLORS)
        pestsPieChart.animateXY(1000, 1000)
        pestsPieChart.setUsePercentValues(true)
        pestsPieChart.setDescription(null)
        val detectionThisWeekItem = ArrayList<BarEntry>()
        detectionThisWeekItem.add(BarEntry(armyWormDataTW.toFloat(), 0))
        detectionThisWeekItem.add(BarEntry(bacterialLeafBlightDataTW.toFloat(), 1))
        detectionThisWeekItem.add(BarEntry(blackBugDataTW.toFloat(), 2))
        detectionThisWeekItem.add(BarEntry(blastDataTW.toFloat(), 3))
        detectionThisWeekItem.add(BarEntry(earBugDataTW.toFloat(), 4))
        detectionThisWeekItem.add(BarEntry(goldenAppleSnailDataTW.toFloat(), 5))
        detectionThisWeekItem.add(BarEntry(greenLeafhopperDataTW.toFloat(), 6))
        detectionThisWeekItem.add(BarEntry(sheathBlightDataTW.toFloat(), 7))
        detectionThisWeekItem.add(BarEntry(tungroDataTW.toFloat(), 8))
        val detectionThisWeekItemLabel = ArrayList<String>()
        detectionThisWeekItemLabel.add("Army Worm")
        detectionThisWeekItemLabel.add("BLB")
        detectionThisWeekItemLabel.add("RBB")
        detectionThisWeekItemLabel.add("Blast")
        detectionThisWeekItemLabel.add("Ear Bug")
        detectionThisWeekItemLabel.add("GAS")
        detectionThisWeekItemLabel.add("GLH")
        detectionThisWeekItemLabel.add("Sheath Blight")
        detectionThisWeekItemLabel.add("Tungro")
        val barChart = findViewById<BarChart>(R.id.thisWeekChart)
        val barDataset = BarDataSet(detectionThisWeekItem, "Total Detections")
        barChart.animateY(1000)
        val barDatasetData = BarData(detectionThisWeekItemLabel, barDataset)
        barDataset.setColors(ColorTemplate.PASTEL_COLORS)
        barChart.data = barDatasetData
        barChart.setDescription(null)
        btnClearData = findViewById<View>(R.id.btnClearData) as Button
        btnClearData!!.setOnClickListener {
            val alertDialogBuilder = AlertDialog.Builder(this@Statistics)
            alertDialogBuilder.setMessage("Are you sure you wanted to clear the data? " +
                    "After deleting, you could no longer retrieve it back.")
            alertDialogBuilder.setPositiveButton("yes"
            ) { dialogInterface, i ->
                val dataList = db.allInfo
                val dataCount = db.countAllData()
                for (j in 0 until dataCount) {
                    db.deleteInfo(dataList[j])
                }
                Toast.makeText(this@Statistics, "All data were cleared",
                        Toast.LENGTH_LONG).show()
                Restart()
            }
            alertDialogBuilder.setNegativeButton("no"
            ) { dialogInterface, i -> Restart() }
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }
    }

    fun Restart() {
        recreate()
    }

    fun backActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_settings -> {
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