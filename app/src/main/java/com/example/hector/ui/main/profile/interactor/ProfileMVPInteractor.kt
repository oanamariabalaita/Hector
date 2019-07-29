package com.example.hector.ui.main.profile.interactor

import com.example.hector.base.interactor.MVPInteractor
import com.example.hector.data.local.users.User
import io.reactivex.Observable

interface ProfileMVPInteractor : MVPInteractor {

    fun doServerApiCall(): Observable<User>

}