package com.example.hector.base.remote

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

open class BaseRemote {

    public fun <T> create(c: Class<T>, baseUrl: String): T {
        return retrofit(baseUrl).create(c)
    }

    private fun retrofit(baseUrl: String): Retrofit {
        val okHttpClient = OkHttpClient().newBuilder()
            .build()

        val gsonBuilder = GsonBuilder()

        val customGson = gsonBuilder.create()

        return Retrofit.Builder()
            .baseUrl(baseUrl).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(customGson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}