package com.example.hector.ui.intro.slider.slidefour

import com.example.hector.ui.intro.slider.slidefour.view.SlideFourFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SlideFourFragmentProvider {

    @ContributesAndroidInjector
    abstract internal fun provideSlideFourFragment(): SlideFourFragment
}