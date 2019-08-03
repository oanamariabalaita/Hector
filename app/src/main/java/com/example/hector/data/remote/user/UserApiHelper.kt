package com.example.hector.data.remote.user

import com.example.hector.base.api.ApiHelper
import com.example.hector.utils.ApiConstants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserApiHelper @Inject constructor() : ApiHelper() {

    companion object {
        const val TIME_OUT: Long = 500
    }

    val userApiService: UserApiService by lazy { initUserApiService() }

    private fun initUserApiService(): UserApiService {
        val clientBuilder = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1L, TimeUnit.SECONDS)
            .writeTimeout(1L, TimeUnit.SECONDS)
        clientBuilder.addInterceptor {
            it.proceed(createInterceptorRequest(it))
        }
        val endpoint = ApiConstants.BASE_URL + ApiConstants.ENDPOINT_SERVER__USER
        val retrofit = initRxRetrofit(endpoint, clientBuilder.build())
        return retrofit.create(UserApiService::class.java)
    }

    private fun createInterceptorRequest(chain: Interceptor.Chain): Request {
        val original = chain.request()
        val builder = original.newBuilder()
        return builder.build()
    }


}