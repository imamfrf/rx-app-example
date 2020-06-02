package com.imamfrf.data.models

import com.google.gson.annotations.SerializedName

data class BaseResponse<Any>(
    @SerializedName("data") var data: Any
) {
}