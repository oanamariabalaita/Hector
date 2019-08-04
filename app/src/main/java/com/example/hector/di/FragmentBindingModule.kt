package com.example.hector.di

import com.example.hector.annotations.PerFragment
import com.example.hector.ui.main.dashboard.view.DashboardFragment
import com.example.hector.ui.main.notifications.view.NotificationsFragment
import com.example.hector.ui.main.profile.view.ProfileFragment
import com.example.hector.ui.main.settings.view.SettingsFragment
import com.example.hector.ui.main.statistics.view.StatisticsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBindingModule {

    @PerFragment
    @ContributesAndroidInjector
    internal abstract fun provideProfileFragment(): ProfileFragment

    @PerFragment
    @ContributesAndroidInjector
    internal abstract fun provideDashboardFragment(): DashboardFragment

    @PerFragment
    @ContributesAndroidInjector
    internal abstract fun provideStatisticsFragment(): StatisticsFragment

    @PerFragment
    @ContributesAndroidInjector
    internal abstract fun provideNotificationsFragment(): NotificationsFragment

    @PerFragment
    @ContributesAndroidInjector
    internal abstract fun provideSettingsFragment(): SettingsFragment
}