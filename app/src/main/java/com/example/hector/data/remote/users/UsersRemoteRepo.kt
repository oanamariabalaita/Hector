package com.example.hector.data.remote.users

import com.example.hector.data.local.users.User
import io.reactivex.Observable

interface UsersRemoteRepo {

    fun getAllUsers(): Observable<List<User>>

}