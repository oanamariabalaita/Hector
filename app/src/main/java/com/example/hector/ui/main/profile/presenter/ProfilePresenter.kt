package com.example.hector.ui.main.profile.presenter

import com.example.hector.ui.base.presenter.BasePresenter
import com.example.hector.ui.main.profile.interactor.ProfileMVPInteractor
import com.example.hector.ui.main.profile.view.ProfileMVPView
import com.example.hector.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class ProfilePresenter<V : ProfileMVPView, I : ProfileMVPInteractor>
@Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) :
    BasePresenter<V, I>(
        interactor = interactor,
        schedulerProvider = schedulerProvider,
        compositeDisposable = disposable
    ), ProfileMVPPresenter<V, I> {


}