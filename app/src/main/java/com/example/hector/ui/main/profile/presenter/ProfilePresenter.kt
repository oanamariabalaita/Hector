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
            it.performServerApiCall()
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe({ usersListResponse ->
                    view?.updateUserList(usersListResponse)
                }, {
                    Log.d("api", "errorApiCall")
                })
        }
    }

    override fun updateUser(user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMockUser(id: Long): User {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadUserInfo(id: Long): User {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}