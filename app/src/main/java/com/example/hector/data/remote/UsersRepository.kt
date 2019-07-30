package com.example.hector.data.remote

import io.reactivex.schedulers.Schedulers
import com.example.hector.data.local.users.User
import com.example.hector.data.local.users.UsersLocalRepo
import com.example.hector.data.remote.users.UsersRemoteRepo
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import javax.inject.Singleton

@Singleton
class UsersRepository : UsersRepo {

    lateinit var remoteUsersRepo: UsersRemoteRepo
    lateinit var localUsersRepo: UsersLocalRepo

    constructor(remoteUsersRepo: UsersRemoteRepo, localUsersRepo: UsersLocalRepo) {
        this.remoteUsersRepo = remoteUsersRepo
        this.localUsersRepo = localUsersRepo
    }

    override fun getAllUsers(): Observable<List<User>> {

        return Observable.mergeDelayError(
            remoteUsersRepo.getAllUsers().doOnNext(object : Consumer<List<User>> {
                @Throws(Exception::class)
                override fun accept(users: List<User>) {
                    localUsersRepo.addUsers(users)
                }
            }).subscribeOn(Schedulers.io()), localUsersRepo.getAllUsers().subscribeOn(Schedulers.io())
        )
    }
}