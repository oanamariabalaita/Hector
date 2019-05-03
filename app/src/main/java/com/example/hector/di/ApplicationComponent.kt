package com.example.hector.di

import android.app.Application
import com.example.hector.app.MvpApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(ApplicationModule::class), (ActivityBindingModule::class), (AndroidSupportInjectionModule::class)])
interface ApplicationComponent{

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: MvpApp)

}