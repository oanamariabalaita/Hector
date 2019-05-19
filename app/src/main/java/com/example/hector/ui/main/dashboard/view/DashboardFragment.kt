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
import android.graphics.DashPathEffect
import com.example.hector.R
import com.github.mikephil.charting.utils.Utils


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
        heathCardAdapter.refreshList(healthCardList)

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

    override fun setUp() {
    }

}