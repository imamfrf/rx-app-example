package com.imamfrf.data.apiservices


import com.imamfrf.data.models.BaseResponse
import com.imamfrf.domain.models.User
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {

    @GET("api/users")
    fun getUserList(): Single<BaseResponse<List<User>>>

    @GET("api/users/{id}")
    fun getUserDetail(@Path("id") idUser: Int): Single<BaseResponse<User>>
}