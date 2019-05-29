package com.example.hector.ui.main.profile.interactor

import com.example.hector.base.interactor.MVPInteractor
import com.example.hector.data.local.users.User

interface ProfileMVPInteractor : MVPInteractor {

    fun updateUser(user: User)
    fun getUserById(id: Long)

}