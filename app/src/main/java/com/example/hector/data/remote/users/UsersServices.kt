package com.example.hector.data.remote.users

import com.example.hector.data.local.users.User
import io.reactivex.Observable
import retrofit2.http.GET

public interface UsersServices {

    @GET("users")
    fun getUsers(): Observable<List<User>>
}