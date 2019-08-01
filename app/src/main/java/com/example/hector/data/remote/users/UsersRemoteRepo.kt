package com.example.hector.data.remote.users

import com.example.hector.data.local.users.User
import io.reactivex.Observable
import io.reactivex.Single

interface UsersRemoteRepo {

    fun getUserById(id: Long): Single<User>

    fun getAllUsers(): Observable<List<User>>

}