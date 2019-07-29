package com.example.hector.ui.main.profile.presenter

import com.example.hector.base.presenter.MVPPresenter
import com.example.hector.data.local.users.User
import com.example.hector.ui.main.profile.interactor.ProfileMVPInteractor
import com.example.hector.ui.main.profile.view.ProfileMVPView

interface ProfileMVPPresenter<V : ProfileMVPView, I : ProfileMVPInteractor> : MVPPresenter<V, I> {

    fun updateUser(user: User)
    fun getMockUser(id: Long): User
    fun loadUserInfo(id: Long): User
}