package com.imamfrf.domain.usecase

import com.imamfrf.domain.models.User
import com.imamfrf.domain.repositories.UserRepository
import io.reactivex.rxjava3.core.Single


import javax.inject.Inject

class GetUserListUseCase @Inject constructor(private var repository: UserRepository) : UseCase<List<User>> {

    override fun execute(param: Any?): Single<List<User>> {
        return repository.getUserList()
    }
}