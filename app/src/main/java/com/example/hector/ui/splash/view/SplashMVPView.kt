package com.example.hector.ui.splash.view

import com.example.hector.base.view.MVPView

interface SplashMVPView : MVPView {

    fun showSuccessToast()
    fun showErrorToast()
    fun openLoginActivity()
    fun openMainActivity()
}