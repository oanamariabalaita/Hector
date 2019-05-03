package com.example.hector.ui.main.dashboard

import com.example.hector.ui.main.dashboard.view.DashboardFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DashboardFragmentProvider {

    @ContributesAndroidInjector
    abstract internal fun provideDashboardFragment(): DashboardFragment

}