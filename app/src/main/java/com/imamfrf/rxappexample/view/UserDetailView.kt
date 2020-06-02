package com.imamfrf.rxappexample.view

import com.imamfrf.domain.models.User

interface UserDetailView {
    fun showUserDetail(user: User)
    fun showProgressBar(isLoading: Boolean)
    fun showError(message: String)
}