package io.github.projectbukirin.palaylab

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import org.eazegraph.lib.charts.PieChart
import org.eazegraph.lib.models.PieModel

class DiseaseStatisticsFragment : Fragment() {
    var tBacterialLeafBlight: TextView? = null
    var tRiceBlast: TextView? = null
    var tSheathBlight: TextView? = null
    var tTungro: TextView? = null
    var pieChart: PieChart? = null
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_disease_statistics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()

        // Link those objects with their
        // respective id's that
        // we have given in .XML file
        tBacterialLeafBlight = view?.findViewById(R.id.tBacterialLeafBlight) as TextView
        tRiceBlast = view?.findViewById(R.id.tRiceBlast) as TextView
        tSheathBlight = view?.findViewById(R.id.tSheathBlight) as TextView
        tTungro = view?.findViewById(R.id.tTungro) as TextView
        pieChart = view?.findViewById(R.id.piechart)

        // Creating a method setData()
        // to set the text in text view and pie chart
        // Set the percentage of language used
        tBacterialLeafBlight!!.text = Integer.toString(40)
        tRiceBlast!!.text = Integer.toString(30)
        tSheathBlight!!.text = Integer.toString(5)
        tTungro!!.text = Integer.toString(25)

        // Set the data and color to the pie chart
        pieChart!!.addPieSlice(
                PieModel(
                        "R", tBacterialLeafBlight!!.text.toString().toInt().toFloat(),
                        Color.parseColor("#FFA726")))
        pieChart!!.addPieSlice(
                PieModel(
                        "Python", tRiceBlast!!.text.toString().toInt().toFloat(),
                        Color.parseColor("#66BB6A")))
        pieChart!!.addPieSlice(
                PieModel(
                        "C++", tSheathBlight!!.text.toString().toInt().toFloat(),
                        Color.parseColor("#EF5350")))
        pieChart!!.addPieSlice(
                PieModel(
                        "Java", tTungro!!.text.toString().toInt().toFloat(),
                        Color.parseColor("#29B6F6")))

        // To animate the pie chart
        pieChart!!.startAnimation()
    }
}