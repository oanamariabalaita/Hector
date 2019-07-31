package com.example.hector.api.user

import com.example.hector.data.local.users.User
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserResponse(
    @Expose
    @SerializedName("status_code")
    private var statusCode: String? = null,

    @Expose
    @SerializedName("message")
    private var message: String? = null,

    @Expose
    @SerializedName("data")
    var data: List<User>? = null
)