package com.example.hector.ui.main.profile.presenter

import com.example.hector.base.presenter.MVPPresenter
import com.example.hector.data.local.user.User
import com.example.hector.ui.main.profile.interactor.ProfileMVPInteractor
import com.example.hector.ui.main.profile.view.ProfileMVPView
import java.util.*

interface ProfileMVPPresenter<V : ProfileMVPView, I : ProfileMVPInteractor> : MVPPresenter<V, I> {

    fun updateUser(id: Long, user: User)
    fun getMockUser(id: Long)
    fun onMockDataPrepared()
}