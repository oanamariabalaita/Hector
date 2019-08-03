package com.example.hector.ui.main.dashboard.interactor.view

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.hector.R
import com.example.hector.base.view.BaseActivity
import com.example.hector.base.view.BaseFragment
import com.example.hector.ui.main.dashboard.view.DashboardFragment
import com.example.hector.ui.main.notifications.view.NotificationsFragment
import com.example.hector.ui.main.profile.view.ProfileFragment
import com.example.hector.ui.main.settings.view.SettingsFragment
import com.example.hector.ui.main.statistics.view.StatisticsFragment
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@Suppress("MagicNumber")
class MainActivity : BaseActivity(), HasSupportFragmentInjector {

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector() = fragmentDispatchingAndroidInjector
    override fun getDefaultFragment(): BaseFragment = DashboardFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDash()
        setListeners()
    }

    private fun setListeners() {
        mainFab.setOnClickListener {
            replaceFragment(
                DashboardFragment.newInstance(),
                false
            )
        }

        mBottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_notifications -> replaceFragment(
                    NotificationsFragment.newInstance(), false
                )

                R.id.action_reports -> replaceFragment(
                    StatisticsFragment.newInstance(), false
                )

                R.id.action_settings -> replaceFragment(
                    SettingsFragment.newInstance(),
                    false
                )

                R.id.action_account -> replaceFragment(
                    ProfileFragment.newInstance(),
                    false
                )
            }
            true
        }
    }

    private fun setDash() = mBottomNavigationView.apply {
        inflateMenu(R.menu.bottom_menu)
        enableAnimation(false)
        labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
        setTextSize(10.0f)
        setIconsMarginTop(16)
        itemTextColor = ColorStateList.valueOf(Color.WHITE)
        setIconSize(32.0F, 32.0F)
        getBottomNavigationItemView(1).background = null
        getBottomNavigationItemView(2).background = null
        getBottomNavigationItemView(3).background = null
        getBottomNavigationItemView(2).isClickable = false
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
