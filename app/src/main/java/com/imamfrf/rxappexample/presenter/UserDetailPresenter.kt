package com.imamfrf.rxappexample.presenter

import com.imamfrf.domain.models.User
import com.imamfrf.domain.usecase.GetUserDetailUseCase
import com.imamfrf.rxappexample.view.UserDetailView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class UserDetailPresenter @Inject constructor(private val getUserDetailUseCase: GetUserDetailUseCase) {

    lateinit var view: UserDetailView
    private val compositeDisposable = CompositeDisposable()

    fun loadUserDetail(idUser: Int) {
        setLoading(true)
        getUserDetail(idUser)
    }

    private fun getUserDetail(idUser: Int) {
        getUserDetailUseCase.execute(idUser)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ user: User ->
                showUserDetail(user)
                setLoading(false)
            },
                {
                    view.showError(it.message.toString())
                    setLoading(false)
                })
    }

    private fun setLoading(isLoading: Boolean) {
        view.showProgressBar(isLoading)
    }

    private fun showUserDetail(user: User) {
        view.showUserDetail(user)
    }

    fun destroy() {
        compositeDisposable.clear()
    }
}