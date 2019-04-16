package com.example.hector.data.network

import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
import javax.inject.Inject

class AppApiHelper @Inject constructor( private val apiHeader: ApiHeader) : ApiHelper{

    override fun performServerLogin(request: LoginRequest.ServerLoginRequest): Observable<LoginResponse> =
        Rx2AndroidNetworking.post(ApiEndpoint.ENDPOINT_SERVER_LOGIN)
            .addHeaders(apiHeader.publicApiHeader)
            .addBodyParameter(request)
            .build()
            .getObjectObservable(LoginResponse::class.java)

    override fun performFBLogin(request: LoginRequest.FacebookLoginRequest): Observable<LoginResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun performGoogleLogin(request: LoginRequest.GoogleLoginRequest): Observable<LoginResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun performTwitterLogin(request: LoginRequest.GoogleLoginRequest): Observable<LoginResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun performLogoutApiCall(): Observable<LogoutResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}