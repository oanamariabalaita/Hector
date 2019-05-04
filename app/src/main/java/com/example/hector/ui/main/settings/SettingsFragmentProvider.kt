package com.example.hector.ui.main.settings

import com.example.hector.ui.main.profile.view.ProfileFragment
import com.example.hector.ui.main.settings.view.SettingsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SettingsFragmentProvider {

    @ContributesAndroidInjector
    abstract internal fun provideSettingsFragment(): SettingsFragment
}