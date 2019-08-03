package com.example.hector.data.remote.user

import com.example.hector.data.local.user.User
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface UserApiService {

    @GET("users")
    fun getUsers(): Observable<List<User>>

    @GET("")
    fun getUserById(): Single<User>


}