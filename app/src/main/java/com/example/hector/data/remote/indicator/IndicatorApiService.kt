package com.example.hector.data.remote.indicator

import com.example.hector.data.local.indicator.HealthIndicator
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface IndicatorApiService {

    @GET("indicators")
    fun getIndicators(): Observable<List<HealthIndicator>>

    @GET("")
    fun getIndicatorById(): Single<HealthIndicator>
}