package com.example.hector.data.remote

import com.example.hector.data.local.users.User
import io.reactivex.Observable
import io.reactivex.Single

interface UsersRepo {

    fun getAllUsers(): Observable<List<User>>
}