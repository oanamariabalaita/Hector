package com.example.hector.ui.splash.view

import com.example.hector.ui.base.view.MVPView

interface SplashMVPView : MVPView {

    fun showSuccessToast()
    fun showErrorToast()
    fun openLoginActivity()
    fun openMainActivity()
}