package com.imamfrf.domain.usecase

import io.reactivex.rxjava3.core.Single

interface UseCase<Any> {

    fun execute(param: kotlin.Any? = null) : Single<Any>
}