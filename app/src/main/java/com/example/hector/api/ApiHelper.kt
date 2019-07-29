package com.example.hector.api

import com.example.hector.data.local.users.User
import io.reactivex.Observable

interface ApiHelper {

    fun performUserApiCall(): Observable<User>

}