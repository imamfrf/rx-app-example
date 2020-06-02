package com.imamfrf.domain.repositories

import com.imamfrf.domain.models.User
import io.reactivex.rxjava3.core.Single

interface UserRepository {

    fun getUserList() : Single<List<User>>
    fun getUserDetail(idUser: Int) : Single<User>
}