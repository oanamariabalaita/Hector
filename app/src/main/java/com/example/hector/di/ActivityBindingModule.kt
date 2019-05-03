package com.example.hector.di

import com.example.hector.ui.base.view.BaseFragment
import com.example.hector.ui.main.dashboard.DashboardFragmentProvider
import com.example.hector.ui.main.dashboard.interactor.view.MainActivity
import com.example.hector.ui.main.notifications.NotificationsFragmentProvider
import com.example.hector.ui.main.notifications.view.NotificationsFragment
import com.example.hector.ui.main.report.ReportFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
 abstract class ActivityBindingModule {

 @ContributesAndroidInjector(modules = [(DashboardFragmentProvider::class), (NotificationsFragmentProvider::class), (ReportFragmentProvider::class)])
 abstract fun bindMainActivity(): MainActivity

}