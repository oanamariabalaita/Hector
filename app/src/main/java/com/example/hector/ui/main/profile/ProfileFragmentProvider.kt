package com.example.hector.ui.main.profile

import com.example.hector.ui.main.profile.view.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ProfileFragmentProvider {

    @ContributesAndroidInjector(modules = [ProfileFragmentModule::class])
    internal abstract fun provideProfileFragment(): ProfileFragment
}