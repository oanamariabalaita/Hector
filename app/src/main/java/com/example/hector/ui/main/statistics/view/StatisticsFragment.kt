package com.example.hector.ui.main.statistics.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hector.R
import com.example.hector.ui.base.view.BaseFragment

class StatisticsFragment : BaseFragment() {

    companion object {

        internal val TAG = "StatisticsFragment"

        fun newInstance(): StatisticsFragment {
            return StatisticsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_statistics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //   presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUp(){

    }

}