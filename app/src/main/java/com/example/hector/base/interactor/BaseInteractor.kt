package com.example.hector.base.interactor

import com.example.hector.base.api.ApiHelper
import com.example.hector.data.preferences.PreferenceHelper
import javax.inject.Inject

open class BaseInteractor @Inject constructor(
    private var mApiHelper: ApiHelper,
    private var mPreferenceHelper: PreferenceHelper
) : MVPInteractor {


}