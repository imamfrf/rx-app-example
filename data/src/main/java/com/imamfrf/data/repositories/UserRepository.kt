package com.imamfrf.data.repositories

import com.imamfrf.data.apiservices.ApiServices
import com.imamfrf.data.mapper.UserResponseMapper
import com.imamfrf.domain.models.User
import com.imamfrf.domain.repositories.UserRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiServices: ApiServices,
                                         private val responseMapper: dagger.Lazy<UserResponseMapper>) :
    UserRepository {

    override fun getUserList(): Single<List<User>> {
        return apiServices.getUserList().map {
            responseMapper.get().toUserList(it)
        }
    }

    override fun getUserDetail(idUser: Int): Single<User> {
        return apiServices.getUserDetail(idUser).map {
            responseMapper.get().toSingleUser(it)
        }
    }
}