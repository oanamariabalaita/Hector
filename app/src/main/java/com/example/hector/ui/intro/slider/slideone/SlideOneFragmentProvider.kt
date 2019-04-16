package com.example.hector.ui.intro.slider.slideone

import com.example.hector.ui.intro.slider.slideone.view.SlideOneFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SlideOneFragmentProvider {

    @ContributesAndroidInjector
    abstract internal fun provideSlideOneFragment(): SlideOneFragment
}