package com.example.hector.base.interactor

import com.example.hector.data.UsersRepository
import javax.inject.Inject


open class BaseInteractor internal constructor(
) : MVPInteractor {

    @Inject
    protected lateinit var usersRepository: UsersRepository



}