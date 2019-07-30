package com.example.hector.ui.main.profile.view

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hector.R
import com.example.hector.base.view.BaseFragment
import com.example.hector.data.local.users.User
import com.example.hector.ui.main.profile.interactor.ProfileMVPInteractor
import com.example.hector.ui.main.profile.presenter.ProfileMVPPresenter
import kotlinx.android.synthetic.main.fragment_profile.*
import javax.inject.Inject

@SuppressWarnings("TooManyFunctions")
class ProfileFragment : BaseFragment(), ProfileMVPView, View.OnClickListener {
    override fun showErrorUpdateToast() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateUserInfo(user: User) {
        txt_name.text = user.userName
        txt_edit_year_val.setText(user.userBirthYear.toString())
        txt_edit_height_val.setText(user.userHeight.toString())
        txt_edit_step_val.setText(user.userWeight.toString())
    }

    override fun onSaveClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMockDataClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showSuccessUpdateToast() {
        Toast.makeText(context, "User info updated with success!", Toast.LENGTH_SHORT).show()
    }

    lateinit var tfLight: Typeface

    @Inject
    lateinit var presenter: ProfileMVPPresenter<ProfileMVPView, ProfileMVPInteractor>

    companion object {

        internal val TAG = "ProfileFragment"

        fun newInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }

    override fun setUp() {
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this@ProfileFragment)
        super.onViewCreated(view, savedInstanceState)
        tfLight = Typeface.createFromAsset(context?.assets, "OpenSans-Light.ttf")
        txt_name.typeface = tfLight
        txt_activity_level.setTextColor(Color.DKGRAY)
        level1.setOnClickListener(this)
        level2.setOnClickListener(this)
        level3.setOnClickListener(this)
        level4.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v) {
            level1 -> txt_activity_level.text = "SEDENTARY"
            level2 -> txt_activity_level.text = "SOMEWHAT ACTIVE"
            level3 -> txt_activity_level.text = "ACTIVE"
            level4 -> txt_activity_level.text = "VERY ACTIVE"
        }
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}
