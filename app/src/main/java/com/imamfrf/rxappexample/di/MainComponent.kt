package com.imamfrf.rxappexample.di

import com.imamfrf.data.di.ApiModule
import com.imamfrf.data.di.NetworkModule
import com.imamfrf.data.di.RepositoryModule
import com.imamfrf.rxappexample.view.activity.MainActivity
import dagger.Component

@Component(modules = [RepositoryModule::class, ApiModule::class, NetworkModule::class])
interface MainComponent {
    fun inject(activity: MainActivity)
}