package xyz.marcreyes.palaylab.app

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
    var aBacterialLeafBlight: TextView? = null
    var aRiceBlast: TextView? = null
    var aSheathBlight: TextView? = null
    var aTungro: TextView? = null
    var tBacterialLeafBlight: TextView? = null
    var tRiceBlast: TextView? = null
    var tSheathBlight: TextView? = null
    var tTungro: TextView? = null
    var wBacterialLeafBlight: TextView? = null
    var wRiceBlast: TextView? = null
    var wSheathBlight: TextView? = null
    var wTungro: TextView? = null
    var pieChart: PieChart? = null
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_disease_statistics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()

        aBacterialLeafBlight = view.findViewById(R.id.aBacterialLeafBlight) as TextView
        aRiceBlast = view.findViewById(R.id.aRiceBlast) as TextView
        aSheathBlight = view.findViewById(R.id.aSheathBlight) as TextView
        aTungro = view.findViewById(R.id.aTungro) as TextView
        tBacterialLeafBlight = view.findViewById(R.id.tBacterialLeafBlight) as TextView
        tRiceBlast = view.findViewById(R.id.tRiceBlast) as TextView
        tSheathBlight = view.findViewById(R.id.tSheathBlight) as TextView
        tTungro = view.findViewById(R.id.tTungro) as TextView
        wBacterialLeafBlight = view.findViewById(R.id.wBacterialLeafBlight) as TextView
        wRiceBlast = view.findViewById(R.id.wRiceBlast) as TextView
        wSheathBlight = view.findViewById(R.id.wSheathBlight) as TextView
        wTungro = view.findViewById(R.id.wTungro) as TextView
        pieChart = view.findViewById(R.id.piechart)

        val vABacterialLeafBlight = PredictionCounterText("Bacterial Leaf Blight")
        vABacterialLeafBlight.getPredictionTotal(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                aBacterialLeafBlight!!.text = data.toString()
                pieChart!!.addPieSlice(
                        PieModel(
                                "Bacterial Leaf Blight", data.toFloat(),
                                Color.parseColor("#173F5F")))
            }
        })

        val vARiceBlast = PredictionCounterText("Blast")
        vARiceBlast.getPredictionTotal(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                aRiceBlast!!.text = data.toString()
                pieChart!!.addPieSlice(
                        PieModel(
                                "Rice Blast", data.toFloat(),
                                Color.parseColor("#3CAEA3")))
            }
        })

        val vASheathBlight = PredictionCounterText("Sheath Blight")
        vASheathBlight.getPredictionTotal(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                aSheathBlight!!.text = data.toString()
                pieChart!!.addPieSlice(
                        PieModel(
                                "Sheath Blight", data.toFloat(),
                                Color.parseColor("#F6D55C")))
            }
        })

        val vATungro = PredictionCounterText("Tungro")
        vATungro.getPredictionTotal(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                aTungro!!.text = data.toString()
                pieChart!!.addPieSlice(
                        PieModel(
                                "Tungro", data.toFloat(),
                                Color.parseColor("#ED553B")))
            }
        })

        val vBacterialLeafBlight = PredictionCounterText("Bacterial Leaf Blight")
        vBacterialLeafBlight.getPredictionToday(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                tBacterialLeafBlight!!.text = data.toString()
            }
        })

        val vRiceBlast = PredictionCounterText("Blast")
        vRiceBlast.getPredictionToday(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                tRiceBlast!!.text = data.toString()
            }
        })

        val vSheathBlight = PredictionCounterText("Sheath Blight")
        vSheathBlight.getPredictionToday(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                tSheathBlight!!.text = data.toString()
            }
        })

        val vTungro = PredictionCounterText("Tungro")
        vTungro.getPredictionToday(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                tTungro!!.text = data.toString()
            }
        })

        val vWBacterialLeafBlight = PredictionCounterText("Bacterial Leaf Blight")
        vWBacterialLeafBlight.getPredictionThisWeek(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                wBacterialLeafBlight!!.text = data.toString()
            }
        })

        val vWRiceBlast = PredictionCounterText("Blast")
        vWRiceBlast.getPredictionThisWeek(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                wRiceBlast!!.text = data.toString()
            }
        })

        val vWSheathBlight = PredictionCounterText("Sheath Blight")
        vWSheathBlight.getPredictionThisWeek(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                wSheathBlight!!.text = data.toString()
            }
        })

        val vWTungro = PredictionCounterText("Tungro")
        vWTungro.getPredictionThisWeek(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                wTungro!!.text = data.toString()
            }
        })

        pieChart!!.startAnimation()
    }
}