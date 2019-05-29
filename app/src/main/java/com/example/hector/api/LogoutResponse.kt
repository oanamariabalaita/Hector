package com.example.hector.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LogoutResponse constructor(@Expose
                                      @SerializedName("status_code")
                                      private var statusCode: String? = null,
                                      @Expose
                                      @SerializedName("message")
                                      private var message: String? = null) {
}