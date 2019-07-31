package com.example.hector.api.user

import com.example.hector.data.local.users.User
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApiService {

    @GET("users")
    fun getAllOnBase(@Query("base") base: User):
            Observable<UserResponse>
}