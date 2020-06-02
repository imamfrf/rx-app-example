package com.imamfrf.rxappexample.view

import com.imamfrf.domain.models.User

interface MainView {
    fun showUserList(userList: List<User>)
    fun showProgressBar(isLoading: Boolean)
    fun showError(message: String)
}