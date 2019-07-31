package com.example.hector.ui.main.profile.interactor

import com.example.hector.api.ApiHelper
import com.example.hector.data.preferences.PreferenceHelper
import com.example.hector.base.interactor.BaseInteractor
import com.example.hector.data.local.users.User
import io.reactivex.Observable
import javax.inject.Inject

class ProfileInteractor @Inject internal constructor(
    preferenceHelper: PreferenceHelper,
    apiHelper: ApiHelper
) : BaseInteractor(preferenceHelper, apiHelper), ProfileMVPInteractor {

    override fun performServerApiCall(): Observable<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
