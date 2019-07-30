package com.example.hector.base.interactor

import com.example.hector.data.preferences.PreferenceHelper

open class BaseInteractor() : MVPInteractor {

    protected lateinit var apiHelper: ApiHelper

    constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : this() {
        this.apiHelper = apiHelper
    }

}