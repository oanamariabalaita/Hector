package com.example.hector.ui.main.profile.view

import com.example.hector.base.view.MVPView
import com.example.hector.data.local.user.User

interface ProfileMVPView : MVPView {

    fun showSuccessUpdateToast()

    fun showErrorUpdateToast()

    fun openDashboardFragment()

    fun showUserInfo(user: User)

    fun loadMockUser(user: User)

    fun loadUsersList(list: List<User>?)

    fun saveUserInfo(user: User)
}