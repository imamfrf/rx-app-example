package com.imamfrf.data.di

import com.imamfrf.data.apiservices.ApiServices
import com.imamfrf.data.mapper.UserResponseMapper
import com.imamfrf.data.repositories.UserRepository
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideUserListRepository(apiServices: ApiServices, responseMapper: Lazy<UserResponseMapper>): com.imamfrf.domain.repositories.UserRepository {
        return UserRepository(apiServices, responseMapper)
    }
}