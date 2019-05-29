package com.example.hector.ui.main.profile.interactor

import android.content.Context
import com.example.hector.api.ApiHelper
import com.example.hector.data.database.users.UsersRepo
import com.example.hector.data.preferences.PreferenceHelper
import com.example.hector.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class ProfileInteractor @Inject constructor(
    private val mContext: Context,
    private val userRepoHelper: UsersRepo,
    private val usersRepoHelper: UsersRepo,
    preferenceHelper: PreferenceHelper,
    apiHelper: ApiHelper
) : BaseInteractor(preferenceHelper, apiHelper), ProfileMVPInteractor {

    override fun submitUserDetails() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}