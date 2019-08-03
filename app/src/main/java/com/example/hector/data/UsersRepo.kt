package com.example.hector.data

import com.example.hector.data.local.user.User
import io.reactivex.Observable
import io.reactivex.Single

interface UsersRepo {

    fun getUserById(id: Long): Single<User>

    fun getAllUsersFromDB(): Observable<List<User>>
}