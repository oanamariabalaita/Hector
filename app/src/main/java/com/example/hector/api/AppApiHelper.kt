package com.example.hector.api

import com.example.hector.data.local.users.User
import io.reactivex.Observable
import javax.inject.Inject

class AppApiHelper @Inject constructor() : ApiHelper {

    override fun performUserApiCall(): Observable<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}