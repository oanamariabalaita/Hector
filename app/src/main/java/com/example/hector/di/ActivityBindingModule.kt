package com.example.hector.di

import com.example.hector.ui.main.dashboard.DashboardFragmentProvider
import com.example.hector.ui.main.dashboard.interactor.view.MainActivity
import com.example.hector.ui.main.notifications.NotificationsFragmentProvider
import com.example.hector.ui.main.profile.ProfileFragmentProvider
import com.example.hector.ui.main.settings.SettingsFragmentProvider
import com.example.hector.ui.main.statistics.StatisticsFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule{

    @ContributesAndroidInjector(modules = [
    (DashboardFragmentProvider::class),
    (NotificationsFragmentProvider::class),
    (StatisticsFragmentProvider::class),
    (SettingsFragmentProvider::class),
    (ProfileFragmentProvider::class)])
    abstract fun bindMainActivity(): MainActivity
}