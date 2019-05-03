package com.example.hector.ui.main.dashboard.interactor.view

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import com.example.hector.R
import com.example.hector.ui.base.view.BaseActivity
import com.example.hector.ui.main.dashboard.view.DashboardFragment
import com.example.hector.ui.main.notifications.view.NotificationsFragment
import com.example.hector.ui.main.report.view.ReportFragment
import com.example.hector.utils.extensions.addFragment
import com.example.hector.utils.extensions.removeFragment
import com.example.hector.utils.extensions.replaceFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@Suppress("MagicNumber")
class MainActivity : BaseActivity(), HasSupportFragmentInjector {

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>


    override fun supportFragmentInjector() = fragmentDispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDash()
        setListeners()
    }

    private fun setListeners() {
        mainFab.setOnClickListener {
            supportFragmentManager.replaceFragment(
                R.id.fragmentContainer,
                DashboardFragment.newInstance(),
                DashboardFragment.TAG
            )
        }

        mBottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_notifications -> supportFragmentManager.replaceFragment(
                    R.id.fragmentContainer,
                    NotificationsFragment.newInstance(),
                    NotificationsFragment.TAG
                )
                R.id.action_reports -> supportFragmentManager.replaceFragment(
                    R.id.fragmentContainer,
                    ReportFragment.newInstance(),
                    ReportFragment.TAG
                )
            }
            true
        }
    }

    private fun setDash() = mBottomNavigationView.apply {
        inflateMenu(R.menu.bottom_menu)
        enableAnimation(false)
        enableItemShiftingMode(false)
        enableShiftingMode(false)
        enableAnimation(false)
        setTextSize(10.0f)
        setIconsMarginTop(10)
        setIconSize(32.0F, 32.0F)
        getBottomNavigationItemView(0).background = null
        getBottomNavigationItemView(1).background = null
//        getBottomNavigationItemView(2).isClickable = false
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
        supportFragmentManager?.removeFragment(tag = tag)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
