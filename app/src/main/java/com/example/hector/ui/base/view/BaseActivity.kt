package com.example.hector.ui.base.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.hector.utils.CommonUtil
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity(), MVPView, BaseFragment.CallBack{

    private var progressBar : ProgressBar? = null

    override fun onCreate(savedInstanceState : Bundle?){
        performDI()
        super.onCreate(savedInstanceState)
    }

    override fun showProgress() {
        hideProgress()
        progressBar = CommonUtil.showLoadingBar(this)

    }

    override fun hideProgress() {
        progressBar?.let { if (it.isVisible) it.visibility = View.GONE }
    }

    private fun performDI() = AndroidInjection.inject(this)
}