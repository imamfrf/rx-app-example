package com.imamfrf.rxappexample.di

import com.imamfrf.data.di.ApiModule
import com.imamfrf.data.di.NetworkModule
import com.imamfrf.data.di.RepositoryModule
import com.imamfrf.rxappexample.view.activity.MainActivity
import com.imamfrf.rxappexample.view.activity.UserDetailActivity
import dagger.Component

@Component(modules = [RepositoryModule::class, ApiModule::class, NetworkModule::class])
interface UserDetailComponent {
    fun inject(activity: UserDetailActivity)
}