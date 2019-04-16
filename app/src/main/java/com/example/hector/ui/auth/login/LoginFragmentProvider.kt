package com.example.hector.ui.auth.login

import com.example.hector.ui.auth.login.view.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class LoginFragmentProvider {

    @ContributesAndroidInjector(modules = [LoginFragmentModule::class])
    internal abstract fun provideLoginFragmentFactory(): LoginFragment
}
