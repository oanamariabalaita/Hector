package com.example.hector.data.database.users

import javax.inject.Inject

class UsersRepository @Inject constructor(private val usersDao: UsersDao) : UsersRepo {
}