package com.example.hector.ui.intro.slider.slidetwo

import com.example.hector.ui.intro.slider.slidetwo.view.SlideTwoFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SlideTwoFragmentProvider {

    @ContributesAndroidInjector
    abstract internal fun provideSlideTwoFragment() : SlideTwoFragment
}