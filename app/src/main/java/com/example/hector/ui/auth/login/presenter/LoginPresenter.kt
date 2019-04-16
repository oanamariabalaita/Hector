package com.example.hector.ui.auth.login.presenter

import com.example.hector.data.network.LoginResponse
import com.example.hector.ui.auth.login.interactor.LoginMVPInteractor
import com.example.hector.ui.auth.login.view.LoginMVPView
import com.example.hector.ui.base.presenter.BasePresenter
import com.example.hector.utils.AppConstants
import com.example.hector.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LoginPresenter< V : LoginMVPView, I: LoginMVPInteractor> @Inject internal constructor( interactor : I, schedulerProvider: SchedulerProvider, disposable : CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), LoginMVPPresenter<V, I> {

    override fun onServerLoginClicked(email: String, password: String) {
        when {
            email.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_EMAIL_ERROR)
            password.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_PASSWORD_ERROR)
            else -> {
                getView()?.showProgress()
                interactor?.let {
                    compositeDisposable.add(it.doServerLoginApiCall(email, password)
                        .compose(schedulerProvider.ioToMainObservableScheduler())
                        .subscribe({ loginResponse ->
                            updateUserInSharedPref(loginResponse = loginResponse,
                                loggedInMode = AppConstants.LoggedInMode.LOGGED_IN_MODE_SERVER)
                            getView()?.openMainActivity()
                        }, { err -> println(err) }))
                }

            }
        }
    }

    override fun onFBLoginClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onGoogleLoginClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTwitterLoginCLiked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun updateUserInSharedPref(loginResponse: LoginResponse,
                                       loggedInMode: AppConstants.LoggedInMode) =
        interactor?.updateUserInSharedPref(loginResponse, loggedInMode)


}