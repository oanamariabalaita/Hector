package com.example.hector.ui.auth.login

import com.example.hector.ui.auth.login.interactor.LoginInteractor
import com.example.hector.ui.auth.login.interactor.LoginMVPInteractor
import com.example.hector.ui.auth.login.presenter.LoginMVPPresenter
import com.example.hector.ui.auth.login.presenter.LoginPresenter
import com.example.hector.ui.auth.login.view.LoginMVPView
import dagger.Module
import dagger.Provides

@Module
class LoginFragmentModule {

    @Provides
    internal fun provideLoginInteractor(interactor: LoginInteractor): LoginMVPInteractor = interactor

    @Provides
    internal fun provideLoginPresenter(presenter: LoginPresenter<LoginMVPView, LoginMVPInteractor>)
            : LoginMVPPresenter<LoginMVPView, LoginMVPInteractor> = presenter

}