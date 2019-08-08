package com.example.hector.data

import com.example.hector.data.local.user.User
import io.reactivex.Observable
import io.reactivex.Single

interface UsersRepo {

    fun getUserById(id: Long): Single<User>

    fun storeUserInDB(user: User)

    fun getUsersFromDB(): Observable<List<User>>

    fun getUsersFromAPI(): Observable<List<User>>

    fun getUsers(): Observable<List<User>>

    fun editUserInDB(user: User)

    fun editUserFromApi(user: User)
}