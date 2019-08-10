package com.example.hector.ui.main.profile.interactor

import com.example.hector.base.interactor.BaseInteractor
import com.example.hector.data.local.user.User
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class ProfileInteractor @Inject internal constructor() :
    BaseInteractor(), ProfileMVPInteractor {

    override fun getUserByIdApiCall(id: Long): Observable<User> {
         return usersRepository.userApiHelper.userApiService.getUserById(id)
    }

    override fun editUserApiCAll(id: Long, user: User): Single<Any> {
        return usersRepository.userApiHelper.userApiService.updateUser(id, user)
    }

    override fun deleteUserApiCall(id: Long): Single<Any> {
       return usersRepository.userApiHelper.userApiService.deleteUser(id)
    }

    override fun createUserApiCall(user: User) : Single<Any>{
       return usersRepository.userApiHelper.userApiService.addUser(user)
    }

    override fun getUsersApiCall(): Observable<List<User>> {
        return usersRepository.userApiHelper.userApiService.getAllUsers()
    }
}
