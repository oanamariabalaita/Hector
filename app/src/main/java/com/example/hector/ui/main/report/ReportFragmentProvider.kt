package com.example.hector.ui.main.report

import com.example.hector.ui.main.report.view.ReportFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ReportFragmentProvider {

    @ContributesAndroidInjector
    abstract internal fun provideReportFragment(): ReportFragment
}