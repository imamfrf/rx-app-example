package com.imamfrf.data.mapper

import com.imamfrf.data.models.BaseResponse
import com.imamfrf.domain.models.User
import javax.inject.Inject

class UserResponseMapper @Inject constructor(){

    fun toUserList(response: BaseResponse<List<User>>): List<User>{
        return response.data
    }

    fun toSingleUser(response: BaseResponse<User>): User{
        return response.data
    }
}