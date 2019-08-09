package com.example.hector.data.local.user

import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class UsersLocalRepository @Inject constructor(private val usersDao: UsersDao) : UsersLocalRepo {
    override fun deleteUser(id: Long) {

        TODO("not implemented")
    }

    override fun addUser(user: User) {
        usersDao.insertUser(user)
    }

    override fun getUserById(id: Long): Single<User> {
        return Single.fromCallable { usersDao.getUserById(id) }
    }

    override fun updateUser(user: User) {
        user.apply {
            usersDao.update(
                id,
                userName,
                userGender,
                userBirthYear,
                userHeight,
                userWeight,
                userActivityLevel
            )
        }
    }

    override fun getAllUsers(): Observable<List<User>> {
        return usersDao.getAll()
    }


}