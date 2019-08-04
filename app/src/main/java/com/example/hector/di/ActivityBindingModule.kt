package com.example.hector.di

import com.example.hector.ui.main.dashboard.interactor.view.MainActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(
        modules = [
            (ActivityModule::class), (FragmentBindingModule::class)]
    )
    abstract fun bindMainActivity(): MainActivity

}