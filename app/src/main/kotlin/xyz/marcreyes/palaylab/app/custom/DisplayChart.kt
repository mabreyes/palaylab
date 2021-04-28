package xyz.marcreyes.palaylab.app.custom

import android.graphics.Color
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import java.util.*

class DisplayChart {
    fun barChart(barChart: BarChart, arrayList: ArrayList<BarEntry>, xAxisValues: ArrayList<String>) {
        barChart.setDrawBarShadow(false)
        barChart.setFitBars(true)
        barChart.setDrawValueAboveBar(true)
        barChart.setMaxVisibleValueCount(25)
        barChart.setPinchZoom(true)
        barChart.setDrawGridBackground(true)
        val barDataSet = BarDataSet(arrayList, "Values")
        barDataSet.setColors(*ColorTemplate.COLORFUL_COLORS)
        val barData = BarData(barDataSet)
        barData.barWidth = 0.9f
        barData.setValueTextSize(0f)
        barChart.setBackgroundColor(Color.TRANSPARENT) //set whatever color you prefer
        barChart.setDrawGridBackground(false)
        val l = barChart.legend // Customize the ledgends
        l.textSize = 10f
        l.formSize = 10f
        //To set components of x axis
        val xAxis = barChart.xAxis
        xAxis.textSize = 13f
        xAxis.position = XAxis.XAxisPosition.TOP_INSIDE
        xAxis.valueFormatter = IndexAxisValueFormatter(xAxisValues)
        xAxis.setDrawGridLines(false)
        barChart.data = barData
    }

    fun pieChart(piechart: PieChart, arrayList: ArrayList<PieEntry>) {
        piechart.setUsePercentValues(true)
        piechart.description.isEnabled = false
        piechart.setExtraOffsets(2f, 5f, 2f, 2f)
        piechart.dragDecelerationFrictionCoef = 0.95f
        piechart.isDrawHoleEnabled = true
        piechart.setHoleColor(Color.WHITE)
        piechart.transparentCircleRadius = 61f
        val pieDataSet = PieDataSet(arrayList, " ")
        pieDataSet.sliceSpace = 3f
        pieDataSet.selectionShift = 5f
        // Custom colors to in the pie chart
        val colors = intArrayOf(Color.rgb(13, 166, 10), Color.rgb(255, 140, 0))
        val arrayList1: ArrayList<Int> = ArrayList()
        for (c in colors) {
            arrayList1.add(c)
        }
        pieDataSet.colors = arrayList1
        pieDataSet.colors = ColorTemplate.createColors(colors)
        val pieData = PieData(pieDataSet)
        pieData.setValueTextSize(18f)
        pieData.setValueTextColor(Color.WHITE)
        piechart.data = pieData
        piechart.setCenterTextSize(30f)
        piechart.setDrawEntryLabels(false)
        piechart.animateY(1000, Easing.EasingOption.EaseInOutCubic)
    }
}