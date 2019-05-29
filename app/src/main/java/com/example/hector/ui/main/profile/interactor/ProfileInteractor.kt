package com.example.hector.ui.main.profile.interactor

import android.content.Context
import com.example.hector.api.ApiHelper
import com.example.hector.data.preferences.PreferenceHelper
import com.example.hector.base.interactor.BaseInteractor
import com.example.hector.data.local.users.User
import com.example.hector.data.remote.UsersRepo
import javax.inject.Inject

class ProfileInteractor @Inject internal constructor(
    preferenceHelper: PreferenceHelper,
    apiHelper: ApiHelper
) : BaseInteractor(preferenceHelper, apiHelper), ProfileMVPInteractor {
    override fun updateUser(user: User) {
    }

    override fun getUserById(id: Long) {
    }
}
