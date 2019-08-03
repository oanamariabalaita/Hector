package com.example.hector.ui.main.profile.interactor

import com.example.hector.base.api.ApiHelper
import com.example.hector.data.preferences.PreferenceHelper
import com.example.hector.base.interactor.BaseInteractor
import com.example.hector.data.local.user.User
import io.reactivex.Observable
import javax.inject.Inject

class ProfileInteractor @Inject internal constructor(
    preferenceHelper: PreferenceHelper,
    apiHelper: ApiHelper
) : BaseInteractor(apiHelper, preferenceHelper), ProfileMVPInteractor {

    override fun performServerApiCall(): Observable<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
