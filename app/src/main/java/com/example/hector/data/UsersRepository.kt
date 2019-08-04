package com.example.hector.data

import io.reactivex.schedulers.Schedulers
import com.example.hector.data.local.user.User
import com.example.hector.data.local.user.UsersDao
import com.example.hector.data.remote.user.UserApiHelper
import io.reactivex.Observable
import io.reactivex.Single
import timber.log.Timber
import javax.inject.Singleton

@Singleton
class UsersRepository(val userApiHelper: UserApiHelper, val usersDao: UsersDao) : UsersRepo {

    override fun getUserById(id: Long): Single<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


//    override fun getAllUsersFromDB(): Observable<List<User>> {
//        return usersDao.getAll().filter { it.isNotEmpty() }
//            .toObservable()
//            .doOnNext {
//                Timber.d("Dispatching ${it.size} users from DB...")
//            }
//    }


    fun getUsersFromApi(): Observable<List<User>> {
        return userApiHelper.userApiService.getUsers()
            .doOnNext {
                Timber.d("Dispatching ${it.size} users from API...")
                storeUsersInDb(it)
            }
    }

    fun getUsers(): Observable<List<User>> {
        return Observable.concatArray(
            //getAllUsersFromDB(),
            getUsersFromApi()
        )
    }

    fun storeUsersInDb(users: List<User>) {
        Observable.fromCallable { usersDao.insertAll(users) }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe {
                Timber.d("Inserted ${users.size} users from API in DB...")
            }
    }


//        return Observable.mergeDelayError(
//            remoteUsersRepo.getAllUsers().doOnNext(object : Consumer<List<User>> {
//                @Throws(Exception::class)
//                override fun accept(users: List<User>) {
//                    localUsersRepo.addUsers(users)
//                }
//            }).subscribeOn(Schedulers.io()), localUsersRepo.getAllUsers().subscribeOn(Schedulers.io())
//        )
//    }
}