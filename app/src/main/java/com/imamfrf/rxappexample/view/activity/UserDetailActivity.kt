package com.imamfrf.rxappexample.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.imamfrf.domain.models.User
import com.imamfrf.rxappexample.R
import com.imamfrf.rxappexample.di.DaggerUserDetailComponent
import com.imamfrf.rxappexample.presenter.UserDetailPresenter
import com.imamfrf.rxappexample.utils.Constants.toast
import com.imamfrf.rxappexample.view.UserDetailView
import kotlinx.android.synthetic.main.activity_user_detail.*
import javax.inject.Inject

class UserDetailActivity : AppCompatActivity(), UserDetailView {

    companion object {
        const val USER_ID_EXTRA = "user_id_extra"
    }

    @Inject
    lateinit var presenter: UserDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        DaggerUserDetailComponent.create().inject(this)
        presenter.view = this

        val userId = intent.getIntExtra(USER_ID_EXTRA, 0)

        if (userId != 0){
            presenter.loadUserDetail(userId)
        }
    }

    override fun showUserDetail(user: User) {
        text_view_id.text = "User ID : ${user.id}"
        text_view_name.text = "Name : ${user.firstName} ${user.lastName}"
        text_view_email.text = "Email : ${user.email}"
        Glide.with(this).load(user.avatar).into(image_view_avatar)
    }

    override fun showProgressBar(isLoading: Boolean) {
        if (isLoading) {
            layout_progress_bar.visibility = View.VISIBLE
        } else {
            layout_progress_bar.visibility = View.GONE
        }
    }

    override fun showError(message: String) {
        toast(this, message)
    }
}
