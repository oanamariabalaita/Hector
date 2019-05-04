package com.example.hector.ui.main.statistics

import com.example.hector.ui.main.statistics.view.StatisticsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class StatisticsFragmentProvider {

    @ContributesAndroidInjector
    abstract internal fun provideReportFragment(): StatisticsFragment
}