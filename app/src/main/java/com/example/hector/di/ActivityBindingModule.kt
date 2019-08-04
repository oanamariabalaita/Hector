package com.example.hector.di

import com.example.hector.ui.main.dashboard.interactor.view.MainActivity
import com.example.hector.ui.main.profile.view.ProfileFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(
        modules = [
            (ActivityModule::class)]
    )
    abstract fun bindMainActivity(): MainActivity

}