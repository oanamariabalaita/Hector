package com.example.hector.di

import com.example.hector.ui.main.dashboard.interactor.view.MainActivity
import com.example.hector.ui.main.profile.view.ProfileFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BindingModule {

    @ContributesAndroidInjector(
        modules = [
            (ActivityModule::class)]
    )
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun bindProfileFragment(): ProfileFragment

//    @ContributesAndroidInjector
//    internal abstract fun bindDashboardFragment(): DashboardFragment
//
//    @ContributesAndroidInjector
//    internal abstract fun bindSettingsFragment(): SettingsFragment
//
//    @ContributesAndroidInjector
//    internal abstract fun bindStatisticsFragment(): StatisticsFragment
}