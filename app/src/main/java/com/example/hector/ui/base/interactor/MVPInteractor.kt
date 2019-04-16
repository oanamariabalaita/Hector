package com.example.hector.ui.base.interactor

interface MVPInteractor {


    fun isUserLoggedIn(): Boolean

    fun performUserLogout()
}