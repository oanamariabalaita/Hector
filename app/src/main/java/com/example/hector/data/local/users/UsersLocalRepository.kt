package com.example.hector.data.local.users

import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.Callable
import javax.inject.Inject

class UsersLocalRepository @Inject constructor(private val usersDao: UsersDao) : UsersLocalRepo {

    override fun getUserById(id: Long): Single<User> {
        return Single.fromCallable { usersDao.getUserById(id) }

    }

    override fun updateUser(user: User) {
        usersDao.update(
            user.id,
            user.userName,
            user.userGender,
            user.userBirthYear,
            user.userHeight,
            user.userWeight,
            user.userActivityLevel
        )
    }

    override fun getAllUsers(): Observable<List<User>> {
        return Observable.fromCallable { usersDao.getAll() }
    }


    override fun addUsers(users: List<User>) {
        usersDao.insertAll(users)
    }
}