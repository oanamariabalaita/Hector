package com.example.hector.api

import io.reactivex.Observable

interface ApiHelper {

    fun performServerLogin(request: LoginRequest.ServerLoginRequest): Observable<LoginResponse>

    fun performFBLogin(request: LoginRequest.FacebookLoginRequest): Observable<LoginResponse>

    fun performGoogleLogin(request: LoginRequest.GoogleLoginRequest): Observable<LoginResponse>

    fun performTwitterLogin(request: LoginRequest.GoogleLoginRequest): Observable<LoginResponse>

    fun performLogoutApiCall(): Observable<LogoutResponse>

}