package xyz.marcreyes.palaylab.app.pest

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
import xyz.marcreyes.palaylab.app.R
import xyz.marcreyes.palaylab.app.database.CounterCallback
import xyz.marcreyes.palaylab.app.database.PredictionCounterText

class PestStatisticsFragment : Fragment() {
    var aArmyWorm: TextView? = null
    var aGoldenAppleSnail: TextView? = null
    var aGreenLeafhopper: TextView? = null
    var aRiceBlackBug: TextView? = null
    var aRiceEarBug: TextView? = null
    var tArmyWorm: TextView? = null
    var tGoldenAppleSnail: TextView? = null
    var tGreenLeafhopper: TextView? = null
    var tRiceBlackBug: TextView? = null
    var tRiceEarBug: TextView? = null
    var wArmyWorm: TextView? = null
    var wGoldenAppleSnail: TextView? = null
    var wGreenLeafhopper: TextView? = null
    var wRiceBlackBug: TextView? = null
    var wRiceEarBug: TextView? = null
    var pieChartPest: PieChart? = null
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_pest_statistics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()

        aArmyWorm = view.findViewById(R.id.aArmyWorm) as TextView
        aGoldenAppleSnail = view.findViewById(R.id.aGoldenAppleSnail) as TextView
        aGreenLeafhopper = view.findViewById(R.id.aGreenLeafhopper) as TextView
        aRiceBlackBug = view.findViewById(R.id.aRiceBlackBug) as TextView
        aRiceEarBug = view.findViewById(R.id.aRiceEarBug) as TextView
        tArmyWorm = view.findViewById(R.id.tArmyWorm) as TextView
        tGoldenAppleSnail = view.findViewById(R.id.tGoldenAppleSnail) as TextView
        tGreenLeafhopper = view.findViewById(R.id.tGreenLeafhopper) as TextView
        tRiceBlackBug = view.findViewById(R.id.tRiceBlackBug) as TextView
        tRiceEarBug = view.findViewById(R.id.tRiceEarBug) as TextView
        wArmyWorm = view.findViewById(R.id.wArmyWorm) as TextView
        wGoldenAppleSnail = view.findViewById(R.id.wGoldenAppleSnail) as TextView
        wGreenLeafhopper = view.findViewById(R.id.wGreenLeafhopper) as TextView
        wRiceBlackBug = view.findViewById(R.id.wRiceBlackBug) as TextView
        wRiceEarBug = view.findViewById(R.id.wRiceEarBug) as TextView
        pieChartPest = view.findViewById(R.id.pieChartPest)

        val vAArmyWorm = PredictionCounterText("Army Worm")
        vAArmyWorm.getPredictionTotal(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                aArmyWorm!!.text = data.toString()
                pieChartPest!!.addPieSlice(
                        PieModel(
                                "Army Worm", data.toFloat(),
                                Color.parseColor("#173F5F")))
            }
        })

        val vAGoldenAppleSnail = PredictionCounterText("Golden Apple Snail")
        vAGoldenAppleSnail.getPredictionTotal(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                aGoldenAppleSnail!!.text = data.toString()
                pieChartPest!!.addPieSlice(
                        PieModel(
                                "Golden Apple Snail", data.toFloat(),
                                Color.parseColor("#20639B")))
            }
        })

        val vAGreenLeafhopper = PredictionCounterText("Green Leafhopper")
        vAGreenLeafhopper.getPredictionTotal(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                aGreenLeafhopper!!.text = data.toString()
                pieChartPest!!.addPieSlice(
                        PieModel(
                                "Green Leafhopper", data.toFloat(),
                                Color.parseColor("#3CAEA3")))
            }
        })

        val vARiceBlackBug = PredictionCounterText("Black Bug")
        vARiceBlackBug.getPredictionTotal(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                aRiceBlackBug!!.text = data.toString()
                pieChartPest!!.addPieSlice(
                        PieModel(
                                "Rice Black Bug", data.toFloat(),
                                Color.parseColor("#F6D55C")))
            }
        })

        val vARiceEarBug = PredictionCounterText("Ear Bug")
        vARiceEarBug.getPredictionTotal(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                aRiceEarBug!!.text = data.toString()
                pieChartPest!!.addPieSlice(
                        PieModel(
                                "Rice Ear Bug", data.toFloat(),
                                Color.parseColor("#ED553B")))
            }
        })

        val vArmyWorm = PredictionCounterText("Army Worm")
        vArmyWorm.getPredictionToday(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                tArmyWorm!!.text = data.toString()
            }
        })

        val vGoldenAppleSnail = PredictionCounterText("Golden Apple Snail")
        vGoldenAppleSnail.getPredictionToday(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                tGoldenAppleSnail!!.text = data.toString()
            }
        })

        val vGreenLeafhopper = PredictionCounterText("Green Leafhopper")
        vGreenLeafhopper.getPredictionToday(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                tGreenLeafhopper!!.text = data.toString()
            }
        })

        val vRiceBlackBug = PredictionCounterText("Black Bug")
        vRiceBlackBug.getPredictionToday(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                tRiceBlackBug!!.text = data.toString()
            }
        })

        val vRiceEarBug = PredictionCounterText("Ear Bug")
        vRiceEarBug.getPredictionToday(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                tRiceEarBug!!.text = data.toString()
            }
        })

        val vWArmyWorm = PredictionCounterText("Army Worm")
        vWArmyWorm.getPredictionThisWeek(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                wArmyWorm!!.text = data.toString()
            }
        })

        val vWGoldenAppleSnail = PredictionCounterText("Golden Apple Snail")
        vWGoldenAppleSnail.getPredictionThisWeek(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                wGoldenAppleSnail!!.text = data.toString()
            }
        })

        val vWGreenLeafhopper = PredictionCounterText("Green Leafhopper")
        vWGreenLeafhopper.getPredictionThisWeek(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                wGreenLeafhopper!!.text = data.toString()
            }
        })

        val vWRiceBlackBug = PredictionCounterText("Black Bug")
        vWRiceBlackBug.getPredictionThisWeek(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                wRiceBlackBug!!.text = data.toString()
            }
        })

        val vWRiceEarBug = PredictionCounterText("Ear Bug")
        vWRiceEarBug.getPredictionThisWeek(object : CounterCallback<Int> {
            override fun callback(data: Int) {
                wRiceEarBug!!.text = data.toString()
            }
        })

        pieChartPest!!.startAnimation()
    }
}