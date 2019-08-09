package com.example.hector.data

import com.example.hector.data.local.user.User
import com.example.hector.data.local.user.UsersLocalRepository
import com.example.hector.data.remote.user.UserApiHelper
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UsersRepository @Inject constructor() : UsersRepo {

    @Inject
    lateinit var userApiHelper: UserApiHelper

    @Inject
    lateinit var usersLocalRepository: UsersLocalRepository

    override fun editUser(id: Long, user: User) {
        userApiHelper.userApiService.updateUser(id, user)
    }

    override fun deleteUser(id: Long) {
        userApiHelper.userApiService.deleteUser(id)
    }

    override fun createUser(user: User) {
        userApiHelper.userApiService.addUser(user)
    }

    override fun getUserById(id: Long): Single<User> {
        return userApiHelper.userApiService.getUserById(id)
    }

    override fun getUsers(): Observable<List<User>> {
        return userApiHelper.userApiService.getAllUsers()
    }

}