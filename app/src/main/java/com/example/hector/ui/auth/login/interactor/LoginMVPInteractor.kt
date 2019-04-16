package com.example.hector.ui.auth.login.interactor

import com.example.hector.data.network.LoginResponse
import com.example.hector.ui.base.interactor.MVPInteractor
import com.example.hector.utils.AppConstants
import io.reactivex.Observable

interface LoginMVPInteractor : MVPInteractor {

    fun doServerLoginApiCall(email: String, password: String): Observable<LoginResponse>

    fun doFBLoginApiCall(): Observable<LoginResponse>

    fun doGoogleLoginApiCall(): Observable<LoginResponse>

    fun doTwitterLoginApiCall(): Observable<LoginResponse>

    fun updateUserInSharedPref(loginResponse: LoginResponse, loggedInMode: AppConstants.LoggedInMode)

}