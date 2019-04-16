package com.example.hector.di.builder

import com.example.hector.ui.auth.login.LoginFragmentProvider
import com.example.hector.ui.auth.register.RegisterFragmentProvider
import com.example.hector.ui.intro.slider.slidefour.SlideFourFragmentProvider
import com.example.hector.ui.intro.slider.slideone.SlideOneFragmentProvider
import com.example.hector.ui.intro.slider.slidethree.SlideThreeFragmentProvider
import com.example.hector.ui.intro.slider.slidetwo.SlideTwoFragmentProvider
import com.example.hector.ui.intro.view.IntroActivity
import com.example.hector.ui.main.carddetails.CardDetailsFragmentProvider
import com.example.hector.ui.main.dashboard.DashboardFragmentProvider
import com.example.hector.ui.main.dashboard.interactor.view.MainActivity
import com.example.hector.ui.main.notifications.NotificationsFragmentProvider
import com.example.hector.ui.main.report.ReportFragmentProvider
import com.example.hector.ui.profile.ProfileActivityModule
import com.example.hector.ui.profile.view.ProfileActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(SlideOneFragmentProvider::class), (SlideTwoFragmentProvider::class), (SlideThreeFragmentProvider::class), (SlideFourFragmentProvider::class)])
    abstract fun bindIntroActivity(): IntroActivity


//    @ContributesAndroidInjector(modules = [(CardDetailsFragmentProvider::class), (DashboardFragmentProvider::class), (NotificationsFragmentProvider::class), (ReportFragmentProvider::class)])
//    abstract fun bindMainActivity(): MainActivity
//
//    @ContributesAndroidInjector(modules = [(ProfileActivityModule::class)])
//    abstract fun bindProfileActivity(): ProfileActivity

//    @ContributesAndroidInjector(modules = [(SlideOneFragmentProvider::class), (SlideTwoFragmentProvider::class), (SlideThreeFragmentProvider::class), (SlideFourFragmentProvider::class),(LoginFragmentProvider::class), (RegisterFragmentProvider::class)])
//    abstract fun bindIntroActivity(): IntroActivity

//    @ContributesAndroidInjector(modules = [(LoginFragmentProvider::class)])
//    abstract fun bindIntroActivity(): IntroActivity

}