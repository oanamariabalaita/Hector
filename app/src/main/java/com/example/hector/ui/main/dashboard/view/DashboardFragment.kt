package com.example.hector.ui.main.dashboard.view

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hector.data.database.healthIndicators.HealthIndicator
import com.example.hector.ui.base.view.BaseFragment
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import kotlinx.android.synthetic.main.fragment_dashboard.*
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import kotlinx.android.synthetic.main.item_layout_health.*
import android.content.res.Resources
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import androidx.core.content.ContextCompat
import android.graphics.drawable.Drawable
import com.github.mikephil.charting.utils.Utils.getSDKInt
import com.example.hector.R
import com.example.hector.design.RadarMarkerView
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import kotlinx.android.synthetic.main.item_layout_summary.*
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarEntry
import com.github.mikephil.charting.formatter.ValueFormatter


@SuppressWarnings("MagicNumber", "LongMethod")
class DashboardFragment : BaseFragment() {

    companion object {

        internal val TAG = "DashboardFragment"

        fun newInstance(): DashboardFragment {
            return DashboardFragment()
        }
    }

    private val heathCardAdapter: HealthCardAdapter by lazy { HealthCardAdapter() }

    private val healthCardList = mutableListOf<HealthIndicator>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //   presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
        initData()
        initViews()
        initSummaryChart()
        heathCardAdapter.refreshList(healthCardList)

    }

    private fun initSummaryChart() {
        context?.let { ctx ->
            chart_summary.setBackgroundColor(Color.rgb(60, 65, 82))
            chart_summary.description.setEnabled(false)
            chart_summary.webLineWidth = 1f
            chart_summary.webColor = Color.LTGRAY
            chart_summary.webLineWidthInner = 1f
            chart_summary.webColorInner = Color.LTGRAY
            chart_summary.webAlpha = 100

            val mv = RadarMarkerView(ctx, R.layout.radar_markerview)
            mv.setChartView(chart_summary) // For bounds control
            chart_summary.marker = mv // Set the marker to the chart

            setData()

            chart_summary.animateXY(1400, 1400, Easing.EaseInOutQuad)

            var xAxis: XAxis = chart_summary.xAxis
            //  xAxis.setTypeface(tfLight)
            xAxis.setTextSize(9f)
            xAxis.setYOffset(0f)
            xAxis.setXOffset(0f)

            xAxis.valueFormatter = object : ValueFormatter() {

                var mActivities: Array<String> =
                    arrayOf("Weight Management", "Nutrition", "Exercise", "Stress Management", "Pizza")

                override fun getFormattedValue(value: Float): String {
                    return mActivities.get((value % mActivities.size) as Int)
                }
            }

            xAxis.textColor = Color.WHITE

            val yAxis: YAxis = chart_summary.yAxis
            //yAxis.setTypeface(tfLight)
            yAxis.setLabelCount(5, false)
            yAxis.setTextSize(9f)
            yAxis.setAxisMinimum(0f)
            yAxis.setAxisMaximum(80f)
            yAxis.setDrawLabels(false)

            val l: Legend = chart_summary.legend
            l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP)
            l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER)
            l.setOrientation(Legend.LegendOrientation.HORIZONTAL)
            l.setDrawInside(false)
            // l.setTypeface(tfLight);
            l.setXEntrySpace(7f)
            l.setYEntrySpace(5f)
            l.setTextColor(Color.WHITE)

        }
    }

    private fun initData() {
        healthCardList.apply {
            add(
                HealthIndicator(
                    1,
                    "Heart Rate",
                    R.drawable.pulse2,
                    descriptiveVal = "VERY STABLE",
                    quantitativeVal = 165,
                    unit = "BPM"
                )
            )
            add(
                HealthIndicator(
                    2,
                    "Sleep",
                    R.drawable.moon,
                    descriptiveVal = "12 HOURS ",
                    quantitativeVal = 4,
                    unit = "h"
                )
            )
            add(
                HealthIndicator(
                    3,
                    "Caffeine",
                    R.drawable.coffee,
                    descriptiveVal = "3 CUPS PER DAY",
                    quantitativeVal = 3,
                    unit = "cups"
                )
            )
            add(
                HealthIndicator(
                    4,
                    "Water",
                    R.drawable.water,
                    descriptiveVal = "3 CUPS PER DAY",
                    quantitativeVal = 5,
                    unit = "glasses"
                )
            )
            add(
                HealthIndicator(
                    5,
                    "Blood Glucose",
                    R.drawable.glucose,
                    descriptiveVal = "3 CUPS PER DAY",
                    quantitativeVal = 100,
                    unit = "dl/ml"
                )
            )
            add(
                HealthIndicator(
                    6,
                    "Hearth Pressure",
                    R.drawable.hearth_pressure,
                    descriptiveVal = "3 CUPS PER DAY",
                    quantitativeVal = 10
                )
            )
            add(
                HealthIndicator(
                    7,
                    "Active Time",
                    R.drawable.steps,
                    descriptiveVal = "165 BPM - VERY STABLE",
                    quantitativeVal = 1034,
                    unit = "steps"
                )
            )
            add(
                HealthIndicator(
                    8,
                    "Symptom",
                    R.drawable.headache,
                    descriptiveVal = "2 CUPS PER DAY",
                    quantitativeVal = 3
                )
            )

            //     add(HealthIndicator(9, "Active Time", R.drawable.usericon, descriptiveVal = "12 HOURS "))
            //     add(HealthIndicator(10, "Exercise", R.drawable.usericon, descriptiveVal = "3 CUPS PER DAY"))
            //     add(HealthIndicator(11, "Food", R.drawable.usericon, descriptiveVal = "3 CUPS PER DAY"))
//            add(HealthIndicator(12, "Light Exposure", R.drawable.usericon, descriptiveVal = "3 CUPS PER DAY"))
//            add(HealthIndicator(13, "Body Temperature", R.drawable.usericon, descriptiveVal = "3 CUPS PER DAY"))
//            add(HealthIndicator(14, "Weight", R.drawable.usericon, descriptiveVal = "3 CUPS PER DAY"))
//            add(HealthIndicator(15, "Medicine", R.drawable.usericon, descriptiveVal = "3 CUPS PER DAY"))
//            add(HealthIndicator(16, "Mood", R.drawable.usericon, descriptiveVal = "3 CUPS PER DAY"))
//            add(HealthIndicator(17, "Female Health", R.drawable.usericon, descriptiveVal = "3 CUPS PER DAY"))
//            add(HealthIndicator(18, "Custom Card", R.drawable.usericon, descriptiveVal = "3 CUPS PER DAY"))

        }
    }

    private fun initViews() {
        context?.let { ctx ->
            mainRecycleView.apply {
                layoutManager = GridLayoutManager(ctx, 2)
                adapter = heathCardAdapter
            }
        }
    }

    private fun setData() {

        val mul = 80f
        val min = 20f
        val cnt = 5

        val entries1 = ArrayList<RadarEntry>()
        val entries2 = ArrayList<RadarEntry>()

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (i in 0 until cnt) {
            val val1 = (Math.random() * mul).toFloat() + min
            entries1.add(RadarEntry(val1))

            val val2 = (Math.random() * mul).toFloat() + min
            entries2.add(RadarEntry(val2))
        }

        val set1 = RadarDataSet(entries1, "Last Week")
        set1.color = Color.rgb(103, 110, 129)
        set1.fillColor = Color.rgb(103, 110, 129)
        set1.setDrawFilled(true)
        set1.fillAlpha = 180
        set1.lineWidth = 2f
        set1.isDrawHighlightCircleEnabled = true
        set1.setDrawHighlightIndicators(false)

        val set2 = RadarDataSet(entries2, "This Week")
        set2.color = Color.rgb(121, 162, 175)
        set2.fillColor = Color.rgb(121, 162, 175)
        set2.setDrawFilled(true)
        set2.fillAlpha = 180
        set2.lineWidth = 2f
        set2.isDrawHighlightCircleEnabled = true
        set2.setDrawHighlightIndicators(false)

        val sets = ArrayList<IRadarDataSet>()

        sets.add(set1)
        sets.add(set2)

        val data = RadarData(sets)
        //  data.setValueTypeface(tfLight)
        data.setValueTextSize(8f)
        data.setDrawValues(false)
        data.setValueTextColor(Color.WHITE)

        chart_summary.data = data
        chart_summary.invalidate()
    }

    override fun setUp() {
    }

}