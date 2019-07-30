package com.example.hector.ui.main.profile.view

import com.example.hector.base.view.MVPView
import com.example.hector.data.local.users.User

interface ProfileMVPView : MVPView {

    fun showSuccessUpdateToast()

    fun showErrorUpdateToast()

    fun updateUserInfo(user: User)

    fun onSaveClicked()

    fun onMockDataClicked()

}