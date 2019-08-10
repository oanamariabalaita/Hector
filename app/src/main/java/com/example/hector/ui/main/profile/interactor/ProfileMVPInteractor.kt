package com.example.hector.ui.main.profile.interactor

import com.example.hector.base.interactor.MVPInteractor
import com.example.hector.data.local.user.User
import io.reactivex.Observable
import io.reactivex.Single

interface ProfileMVPInteractor : MVPInteractor {

    fun getUsersApiCall(): Observable<List<User>>

    fun getUserByIdApiCall(id: Long): Observable<User>

    fun editUserApiCAll(id: Long, user: User): Single<Any>

    fun deleteUserApiCall(id: Long): Single<Any>

    fun createUserApiCall(user: User): Single<Any>

}