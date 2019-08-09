package com.example.hector.data.remote.user

import com.example.hector.data.local.user.User
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.*

interface UserApiService {

    @GET("users")
    fun getAllUsers(): Observable<List<User>>

    @GET("users")
    fun getUserById(@Path("userId") id: Long): Single<User>

    @POST
    fun addUser(@Body user: User)

    @PUT
    fun updateUser(@Path("userId") id: Long, @Body user: User)

    @DELETE("users")
    fun deleteUser(@Path("userId") id: Long)
}
