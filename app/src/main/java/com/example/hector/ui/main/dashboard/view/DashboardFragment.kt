package com.example.hector.ui.main.dashboard.view

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hector.data.local.indicator.HealthIndicator
import com.example.hector.base.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_dashboard.*
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.hector.R
import com.example.hector.design.RadarMarkerView
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import kotlinx.android.synthetic.main.item_layout_summary.*
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import kotlin.collections.ArrayList

@SuppressWarnings("MagicNumber", "LongMethod", "MaxLineLength", "ComplexMethod")
class DashboardFragment : BaseFragment(), View.OnClickListener, PopupMenu.OnMenuItemClickListener,
    ActivityCompat.OnRequestPermissionsResultCallback {

    companion object {

        internal val TAG = "DashboardFragment"

        fun newInstance(): DashboardFragment {
            return DashboardFragment()
        }
    }

    private final val PERMISSION_STORAGE: Int = 0

    private val heathCardAdapter: HealthCardAdapter by lazy { HealthCardAdapter() }

    private val healthCardList = mutableListOf<HealthIndicator>()

    lateinit var tfLight: Typeface

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //   presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)

        var healthScore: Int = 76
        val spannable = SpannableString(healthScore.toString() + "/100")
        spannable.setSpan(
            RelativeSizeSpan(0.3f),
            2, 6,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        txt_health_score.text = spannable

        initViews()
        initSummaryChart()
        initData()
        heathCardAdapter.refreshList(healthCardList)
    }

    private fun initSummaryChart() {
        context?.let { ctx ->

            chart_summary.description.isEnabled = false
            chart_summary.legend.isEnabled = false
            chart_summary.webLineWidth = 1f
            chart_summary.webColor = Color.BLUE
            chart_summary.webLineWidthInner = 1f
            chart_summary.webColorInner = Color.LTGRAY
            chart_summary.webAlpha = 100
            chart_summary.isHighlightPerTapEnabled = true

            val mv = RadarMarkerView(ctx, R.layout.radar_markerview)
            mv.chartView = chart_summary
            chart_summary.marker = mv

            setData()
            chart_summary.animateXY(1400, 1400, Easing.EaseInOutQuad)
            tfLight = Typeface.createFromAsset(ctx.assets, "OpenSans-Light.ttf")
            val xAxis: XAxis = chart_summary.xAxis
            xAxis.typeface = tfLight
            xAxis.textSize = 10f
            xAxis.yOffset = 0f
            xAxis.xOffset = 0f
            xAxis.valueFormatter = object : ValueFormatter() {

                var mActivities: Array<String> =
                    arrayOf("Weight", "Food", "Sport", "Stress", "Sleep", "Water")

                override fun getFormattedValue(value: Float): String {
                    return mActivities[(value % mActivities.size).toInt()]
                }
            }

            xAxis.textColor = Color.BLACK

            val yAxis: YAxis = chart_summary.yAxis
            yAxis.typeface = tfLight
            yAxis.setLabelCount(6, false)
            yAxis.textSize = 10f
            yAxis.axisMinimum = 0f
            yAxis.axisMaximum = 40f
            yAxis.setDrawLabels(false)


        }
    }

    private fun initData() {
        healthCardList.apply {
            add(
                HealthIndicator(
                    1,
                    "Heart Rate",
                    R.drawable.pulse2.toString(),
                    descriptiveVal = "VERY STABLE",
                    quantitativeVal = 165f,
                    unit = "BPM"
                )
            )
            add(
                HealthIndicator(
                    2,
                    "Sleep",
                    R.drawable.moon.toString(),
                    descriptiveVal = "12 HOURS ",
                    quantitativeVal = 4f,
                    unit = "h"
                )
            )
            add(
                HealthIndicator(
                    3,
                    "Caffeine",
                    R.drawable.coffee.toString(),
                    descriptiveVal = "3 CUPS PER DAY",
                    quantitativeVal = 3f,
                    unit = "cups"
                )
            )
            add(
                HealthIndicator(
                    4,
                    "Water",
                    R.drawable.water.toString(),
                    descriptiveVal = "3 CUPS PER DAY",
                    quantitativeVal = 5f,
                    unit = "glasses"
                )
            )
            add(
                HealthIndicator(
                    5,
                    "Blood Glucose",
                    R.drawable.glucose.toString(),
                    descriptiveVal = "3 CUPS PER DAY",
                    quantitativeVal = 100f,
                    unit = "dl/ml"
                )
            )
            add(
                HealthIndicator(
                    6,
                    "Hearth Pressure",
                    R.drawable.hearth_pressure.toString(),
                    descriptiveVal = "3 CUPS PER DAY",
                    quantitativeVal = 10f
                )
            )
            add(
                HealthIndicator(
                    7,
                    "Active Time",
                    R.drawable.steps.toString(),
                    descriptiveVal = "165 BPM - VERY STABLE",
                    quantitativeVal = 1034f,
                    unit = "steps"
                )
            )
            add(
                HealthIndicator(
                    8,
                    "Symptom",
                    R.drawable.headache.toString(),
                    descriptiveVal = "2 CUPS PER DAY",
                    quantitativeVal = 3f
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
                btn_menu.setOnClickListener(this@DashboardFragment)

            }
        }
    }

    private fun setData() {

        val mul = 30f
        val min = 10f
        val cnt = 6

        val entries1 = ArrayList<RadarEntry>()
        val entries2 = ArrayList<RadarEntry>()

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
        //   set1.fillAlpha = 180
        set1.lineWidth = 1f
        set1.isDrawHighlightCircleEnabled = true
        set1.setDrawHighlightIndicators(false)

        val set2 = RadarDataSet(entries2, "This Week")
        set2.color = Color.rgb(121, 162, 175)
        set2.fillColor = Color.rgb(121, 162, 175)
        set2.setDrawFilled(true)
        //    set2.fillAlpha = 180
        set2.lineWidth = 1f
        set2.isDrawHighlightCircleEnabled = true
        set2.setDrawHighlightIndicators(false)

        val sets = ArrayList<IRadarDataSet>()

        sets.add(set1)
        sets.add(set2)

        val data = RadarData(sets)
        data.setValueTextSize(8f)
        data.setDrawValues(false)
        data.setValueTextColor(Color.BLACK)

        chart_summary.data = data
        chart_summary.invalidate()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_menu -> {
                val wrapper = ContextThemeWrapper(context, R.style.popStyle)
                val popup = PopupMenu(wrapper, btn_menu)
                val inflater: MenuInflater = popup.menuInflater
                inflater.inflate(R.menu.header_menu_dash, popup.menu)

                try {
                    val fieldMPopup = PopupMenu::class.java.getDeclaredField("mPopup")
                    fieldMPopup.isAccessible = true
                    val mPopup = fieldMPopup.get(popup)
                    mPopup.javaClass
                        .getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                        .invoke(mPopup, true)
                } catch (e: Exception) {
                    Log.e("Main", "Error showing menu icons.", e)
                } finally {
                    popup.setOnMenuItemClickListener(this@DashboardFragment)
                    popup.show()
                }
            }
        }
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.action_add_card -> {
                Toast.makeText(context, "1", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_custom_score -> {
                Toast.makeText(context, "2", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_edit_dash -> {
                Toast.makeText(context, "3", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_save_gallery -> {

                if (context?.let {
                        ContextCompat.checkSelfPermission(
                            it,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                        )
                    } == PackageManager.PERMISSION_GRANTED) {
                    //        saveToGallery()
                } else {
                    //       requestStoragePermission(chart_summary)
                }

                true
            }
            R.id.action_reset_val -> {
                Toast.makeText(context, "5", Toast.LENGTH_SHORT).show()
                true
            }

            else -> false
        }
    }


//   override  fun onRequestPermissionsResult(requestCode : Int, @NonNull permissions : Array<String>, @NonNull grantResults: Array<Int>) {
//        if (requestCode == PERMISSION_STORAGE) {
//            if (grantResults.size== 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                saveToGallery()
//            } else {
//                Toast.makeText(getApplicationContext(), "Saving FAILED!", Toast.LENGTH_SHORT)
//                        .show()
//            }
//        }
//    }


    override fun setUp() {
    }
}