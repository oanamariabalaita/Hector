package com.example.hector.data.remote.users

import com.example.hector.base.remote.BaseRemote
import com.example.hector.data.local.users.User
import io.reactivex.Observable
import com.example.hector.base.remote.RemoteConfiguration

class UsersRemoteRepository : BaseRemote(), UsersRemoteRepo {

    override fun getAllUsers(): Observable<List<User>> {
        return create<UsersServices>(UsersServices::class.java, RemoteConfiguration.BASE_URL).getUsers()
    }
}