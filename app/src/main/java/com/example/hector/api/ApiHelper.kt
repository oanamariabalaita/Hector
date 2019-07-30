package com.example.hector.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class ApiHelper {

    protected val gson: Gson
        get() = GsonBuilder().create()

    protected fun initRxRetrofit(endpoint: String, httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(endpoint)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient)
            .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create(Schedulers.io()))
            .build()
    }

}