package com.example.hector.ui.auth.login.view

import com.example.hector.ui.base.view.MVPView

interface LoginMVPView : MVPView {

    fun showValidationMessage(errorCode: Int)
    fun openMainActivity()
    fun openRegisterFragment()
}