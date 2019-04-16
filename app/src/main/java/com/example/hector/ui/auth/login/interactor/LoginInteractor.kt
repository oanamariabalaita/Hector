package com.example.hector.ui.auth.login.interactor

import com.example.hector.data.network.ApiHelper
import com.example.hector.data.network.LoginRequest
import com.example.hector.data.network.LoginResponse
import com.example.hector.data.preferences.AppPreferenceHelper
import com.example.hector.ui.base.interactor.BaseInteractor
import com.example.hector.utils.AppConstants
import io.reactivex.Observable
import javax.inject.Inject

class LoginInteractor @Inject internal constructor( preferenceHelper: AppPreferenceHelper, apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper), LoginMVPInteractor {


    override fun doFBLoginApiCall(): Observable<LoginResponse> =
        apiHelper.performFBLogin(LoginRequest.FacebookLoginRequest("test3", "test4"))


    override fun doServerLoginApiCall(email: String, password: String): Observable<LoginResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun doGoogleLoginApiCall(): Observable<LoginResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun doTwitterLoginApiCall(): Observable<LoginResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateUserInSharedPref(loginResponse: LoginResponse, loggedInMode: AppConstants.LoggedInMode) {
        preferenceHelper.let {
            it.setCurrentUserId(loginResponse.userId)
            it.setAccessToken(loginResponse.accessToken)
            it.setCurrentUserLoggedInMode(loggedInMode)
        }
    }
}
