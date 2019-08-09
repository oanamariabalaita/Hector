package com.example.hector.ui.main.profile.view

import android.util.Log
import com.example.hector.base.view.MVPView
import com.example.hector.data.local.user.User

interface ProfileMVPView : MVPView {

    fun showSuccessUpdateToast()

    fun showErrorUpdateToast()

    fun updateUserInfo(user: User)

    fun onSaveClicked()

    fun onMockDataClicked()

    fun updateUserList(list: List<User>?): Unit?

}