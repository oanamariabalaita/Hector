package com.example.hector.ui.main.profile.presenter

import com.example.hector.ui.base.presenter.MVPPresenter
import com.example.hector.ui.main.profile.interactor.ProfileMVPInteractor
import com.example.hector.ui.main.profile.view.ProfileMVPView


interface ProfileMVPPresenter<V : ProfileMVPView, I : ProfileMVPInteractor> : MVPPresenter<V, I> {

}