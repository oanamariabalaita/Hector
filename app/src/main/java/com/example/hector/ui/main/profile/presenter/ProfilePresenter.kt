package com.example.hector.ui.main.profile.presenter

import android.util.Log
import com.example.hector.base.presenter.BasePresenter
import com.example.hector.data.local.user.User
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

    override fun onMockDataPrepared() {

        interactor?.let {
            it.getUsersApiCall()
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .doOnNext { usersListResponse ->
                    view?.loadUsersList(usersListResponse)
                }
                .doOnError {  Log.d("api", "errorApiCall") }
                .doOnSubscribe { disposable-> compositeDisposable.add(disposable) }
        }
    }

    override fun updateUser(id: Long, user: User) {

        interactor?.let {
            it.editUserApiCAll(id, user )
                .compose(schedulerProvider.ioToMainSingleScheduler())
                .doOnSuccess {
                   view?.apply {
                       showSuccessUpdateToast()
                       showUserInfo(user)}
                   }
                .doOnError {  Log.d("api", "errorUserUpdatedApiCall") }
                .doOnSubscribe { disposable-> compositeDisposable.add(disposable) }
        }
    }

    override fun getMockUser(id: Long) {

        interactor?.let {
            it.getUserByIdApiCall(id)
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .doOnNext { userResponse ->
                    view?.loadMockUser(userResponse) }
                .doOnError {  Log.d("api", "errorMockUserApiCall") }
                .doOnSubscribe { disposable-> compositeDisposable.add(disposable) }
        }
    }

}