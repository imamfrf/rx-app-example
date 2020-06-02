package com.imamfrf.domain.usecase

import com.imamfrf.domain.models.User
import com.imamfrf.domain.repositories.UserRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetUserDetailUseCase @Inject constructor(private val repository: UserRepository) :
    UseCase<User> {
    override fun execute(param: Any?): Single<User> {
        val userId = param.toString().toInt()
        return repository.getUserDetail(userId)
    }
}