package com.example.hector.ui.auth.login.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hector.R
import com.example.hector.ui.auth.login.interactor.LoginMVPInteractor
import com.example.hector.ui.auth.login.presenter.LoginMVPPresenter
import com.example.hector.ui.base.view.BaseFragment
import javax.inject.Inject

class LoginFragment : BaseFragment(), LoginMVPView {

    companion object {

        fun newInstance() : LoginFragment{
            return LoginFragment()
        }
    }

    @Inject
    internal lateinit var presenter : LoginMVPPresenter< LoginMVPView, LoginMVPInteractor>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_login, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun showValidationMessage(errorCode: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openMainActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openRegisterFragment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setUp() {

    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }
}