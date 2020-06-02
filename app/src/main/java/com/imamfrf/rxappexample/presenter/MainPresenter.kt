package com.imamfrf.rxappexample.presenter

import android.util.Log
import com.imamfrf.domain.models.User
import com.imamfrf.domain.usecase.GetUserListUseCase
import com.imamfrf.rxappexample.utils.Constants.TAG

import com.imamfrf.rxappexample.view.MainView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor(private val getUserListUseCase: GetUserListUseCase) {

    lateinit var view: MainView
    private val compositeDisposable = CompositeDisposable()

    fun loadUserList() {
        setLoading(true)
        getUserList()
    }

    private fun getUserList() {
        getUserListUseCase.execute()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ users: List<User>? ->
                showUserList(users!!)
                setLoading(false)
                Log.d(TAG, "users = $users")
            },
                {
                    view.showError(it.message.toString())
                    setLoading(false)
                }
            )
            .let {
                compositeDisposable.add(it)
            }
    }

    private fun setLoading(isLoading: Boolean) {
        view.showProgressBar(isLoading)
    }

    private fun showUserList(userList: List<User>) {
        view.showUserList(userList)
    }

    fun destroy() {
        compositeDisposable.clear()
    }
}