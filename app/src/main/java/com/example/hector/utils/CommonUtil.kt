package com.example.hector.utils

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.ProgressBar
import androidx.core.graphics.drawable.toDrawable
import com.example.hector.R

object CommonUtil {

    fun showLoadingBar( context : Context?) : ProgressBar{
        val progressBar = ProgressBar(context)
        progressBar.let {
            it.visibility = View.VISIBLE
            it.setBackgroundColor(Color.TRANSPARENT)
            it.progressDrawable = (R.layout.progress_bar).toDrawable()
            it.isIndeterminate = true
            return it
        }
    }
}