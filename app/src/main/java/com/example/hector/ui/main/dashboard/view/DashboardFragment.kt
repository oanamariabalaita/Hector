package com.example.hector.ui.main.dashboard.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hector.R
import com.example.hector.data.database.healthIndicators.HealthIndicator
import com.example.hector.ui.base.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_dashboard.*

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
            add(HealthIndicator(1, "Heart Rate", R.drawable.usericon, descriptiveVal = "165 BPM - VERY STABLE"))
            add(HealthIndicator(2, "Sleep", R.drawable.usericon, descriptiveVal = "12 HOURS "))
            add(HealthIndicator(3, "Caffeine", R.drawable.usericon, descriptiveVal = "3 CUPS PER DAY"))
            add(HealthIndicator(4, "Caffeine", R.drawable.usericon, descriptiveVal = "3 CUPS PER DAY"))
            add(HealthIndicator(5, "Caffeine", R.drawable.usericon, descriptiveVal = "3 CUPS PER DAY"))
            add(HealthIndicator(6, "Caffeine", R.drawable.usericon, descriptiveVal = "3 CUPS PER DAY"))
            add(HealthIndicator(7, "Caffeine", R.drawable.usericon, descriptiveVal = "3 CUPS PER DAY"))

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