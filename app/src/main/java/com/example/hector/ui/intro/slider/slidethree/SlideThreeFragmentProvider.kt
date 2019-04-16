package com.example.hector.ui.intro.slider.slidethree

import com.example.hector.ui.intro.slider.slidethree.view.SlideThreeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SlideThreeFragmentProvider {

    @ContributesAndroidInjector
    abstract internal fun provideSlideThreeFragment() : SlideThreeFragment
}