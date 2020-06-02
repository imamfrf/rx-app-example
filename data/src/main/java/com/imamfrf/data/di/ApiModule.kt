package com.imamfrf.data.di

import com.imamfrf.data.apiservices.ApiServices
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {
    @Provides
    fun provideApiService(retrofit: Retrofit) : ApiServices{
        return retrofit.create(ApiServices::class.java)
    }
}