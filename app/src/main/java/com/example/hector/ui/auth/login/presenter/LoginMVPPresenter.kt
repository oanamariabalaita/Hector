package com.example.hector.ui.auth.login.presenter

import com.example.hector.ui.auth.login.interactor.LoginMVPInteractor
import com.example.hector.ui.auth.login.view.LoginMVPView
import com.example.hector.ui.base.presenter.MVPPresenter

interface LoginMVPPresenter<V : LoginMVPView, I: LoginMVPInteractor> : MVPPresenter<V, I> {

    fun onServerLoginClicked(email: String, password: String)
    fun onFBLoginClicked()
    fun onGoogleLoginClicked()
    fun onTwitterLoginCLiked()

}