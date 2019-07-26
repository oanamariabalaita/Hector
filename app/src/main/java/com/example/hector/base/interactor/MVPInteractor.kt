package com.example.hector.base.interactor

interface MVPInteractor {

    fun isUserLoggedIn(): Boolean

    fun performUserLogout()
}