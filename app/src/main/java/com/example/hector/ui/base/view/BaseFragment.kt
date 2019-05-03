package com.example.hector.ui.base.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.example.hector.utils.CommonUtil
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment: Fragment(), MVPView {

     private var parentActivity : BaseActivity? = null
     private var progessBar : ProgressBar? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is BaseActivity){
            val activity = context as BaseActivity?
            this.parentActivity = activity
            activity?.onFragmentAttached()
        }
    }

     override fun onCreate(savedInstanceState: Bundle?) {
         performDependencyInjection()
         super.onCreate(savedInstanceState)
         setHasOptionsMenu(false)
     }

     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         super.onViewCreated(view, savedInstanceState)
         setUp()
     }

     override fun showProgress() {
         progessBar = CommonUtil.showLoadingBar(this.context)

     }

     override fun hideProgress() {
         if (progessBar != null && progessBar?.isShown!!)
             progessBar?.visibility = View.INVISIBLE
     }


    fun getBaseActivity() = parentActivity

    private fun performDependencyInjection() = AndroidSupportInjection.inject(this)

    interface CallBack {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String)
    }

    abstract fun setUp()

}