package com.example.hector.data.remote.users

import com.example.hector.data.local.users.User
import io.reactivex.Observable

class UsersRemoteRepository : UsersRemoteRepo {

    override fun getAllUsers(): Observable<List<User>> {

        TODO("later")
        //  return create<UsersServices>(UsersServices::class.java, RemoteConfiguration.BASE_URL).getUsers()
    }
}