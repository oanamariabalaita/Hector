package com.example.hector.base.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentManager
import com.example.hector.R
import com.example.hector.utils.CommonUtil
import dagger.android.AndroidInjection
import androidx.fragment.app.Fragment

@Suppress("TooManyFunctions")
abstract class BaseActivity : AppCompatActivity(), MVPView, BaseFragment.CallBack {

    @IdRes
    open var containerId: Int = R.id.fragmentContainer

    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        performDI()
        super.onCreate(savedInstanceState)
        getDefaultFragment()?.let {
            replaceFragment(it,false)
        }
    }

    override fun showProgress() {
        hideProgress()
        progressBar = CommonUtil.showLoadingBar(this)
    }

    override fun hideProgress() {
        progressBar?.let { if (it.isVisible) it.visibility = View.GONE }
    }

    open fun getDefaultFragment(): BaseFragment? = null

    private fun performDI() = AndroidInjection.inject(this)

    private fun addFragment(containerViewId: Int, fragment: BaseFragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.add(containerViewId, fragment, fragment.fragmentTag)
        ft.commit()
    }

    protected fun addFragment(fragment: BaseFragment) {
        addFragment(containerId, fragment)
    }

    fun replaceFragment(fragment: BaseFragment, withBackStack: Boolean) {
    //    if(getVisibleFragment().tag!=fragment.tag)
        if (withBackStack) {
            replaceFragmentWithBackStack(containerId, fragment)
        } else {
            replaceFragment(containerId, fragment)
        }
    }

    fun getVisibleFragment(): Fragment? {
        val fragmentManager = getSupportFragmentManager()
        val fragments = fragmentManager.getFragments()
        if (fragments != null) {
            for (fragment in fragments) {
                if (fragment != null && fragment!!.isVisible())
                    return fragment
            }
        }
        return null
    }
    private fun replaceFragmentWithBackStack(containerViewId: Int, fragment: BaseFragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.setCustomAnimations(
            R.anim.enter_from_right,
            R.anim.exit_to_left,
            R.anim.enter_from_left,
            R.anim.exit_to_right
        )
        ft.replace(containerViewId, fragment, fragment.fragmentTag)
        ft.addToBackStack(null)
        ft.commit()
    }

    private fun replaceFragment(containerViewId: Int, fragment: BaseFragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.setCustomAnimations(

            R.anim.enter_from_right,
            R.anim.exit_to_left,
            R.anim.enter_from_left,
            R.anim.exit_to_right
        )
        if (supportFragmentManager.backStackEntryCount != 0)
            ft.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right)
        ft.replace(containerViewId, fragment, fragment.fragmentTag)
        ft.commit()
    }

    fun clearBackStack() {
        if (supportFragmentManager.backStackEntryCount > 0)
            supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
}