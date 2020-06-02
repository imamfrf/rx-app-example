package com.imamfrf.rxappexample.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.imamfrf.domain.models.User
import com.imamfrf.rxappexample.R
import com.imamfrf.rxappexample.di.DaggerMainComponent
import com.imamfrf.rxappexample.presenter.MainPresenter
import com.imamfrf.rxappexample.utils.Constants.toast
import com.imamfrf.rxappexample.view.MainView
import com.imamfrf.rxappexample.view.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(),
    MainView {

    @Inject lateinit var presenter: MainPresenter
    @Inject lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMainComponent.create().inject(this)
        presenter.view = this
        presenter.loadUserList()

    }

    override fun showUserList(userList: List<User>) {
        setupRecyclerView(userList)
    }

    override fun showProgressBar(isLoading: Boolean) {
        if (isLoading){
            layout_progress_bar.visibility = View.VISIBLE
        }
        else{
            layout_progress_bar.visibility = View.GONE
        }
    }

    override fun showError(message: String) {
        toast(this, message)
    }

    private fun setupRecyclerView(list: List<User>){
        adapter.setList(list)
        adapter.setListener(object : MainAdapter.MainListener{
            override fun onItemClicked(user: User) {
                toast(this@MainActivity, "${user.firstName} clicked")
                val intent = Intent(this@MainActivity, UserDetailActivity::class.java)
                intent.putExtra(UserDetailActivity.USER_ID_EXTRA, user.id)
                startActivity(intent)
            }
        })
        recycler_view_user_list.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }
}
