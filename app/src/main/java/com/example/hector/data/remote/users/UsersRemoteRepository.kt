package com.example.hector.data.remote.users

import com.example.hector.data.local.users.User
import com.example.hector.ui.main.profile.interactor.ProfileInteractor
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class UsersRemoteRepository @Inject constructor(private val profileInteractor: ProfileInteractor) : UsersRemoteRepo {

    override fun getUserById(id: Long): Single<User> {
        TODO("ddd")
        //  return Single.fromCallable { profileInteractor.getUserById(id) }
    }

    override fun getAllUsers(): Observable<List<User>> {

        TODO("later")
        //  return create<UsersServices>(UsersServices::class.java, RemoteConfiguration.BASE_URL).getUsers()
    }
}