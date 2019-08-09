package com.example.hector.ui.main.profile.interactor

import com.example.hector.base.interactor.BaseInteractor
import com.example.hector.data.UsersRepository
import com.example.hector.data.local.user.User
import io.reactivex.Observable
import javax.inject.Inject

class ProfileInteractor @Inject internal constructor(
) : BaseInteractor(), ProfileMVPInteractor {


    override fun performServerApiCall(): Observable<List<User>> {
        return usersRepository.userApiHelper.userApiService.getAllUsers()
    }

}
