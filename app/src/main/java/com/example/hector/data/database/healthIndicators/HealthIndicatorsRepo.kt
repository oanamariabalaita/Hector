package com.example.hector.data.database.healthIndicators

import io.reactivex.Observable
import io.reactivex.Single

interface HealthIndicatorsRepo {

    fun isHealthIndicatorsRepoEmpty(): Observable<Boolean>

    fun insertHealthIndicators(healthIndicators: List<HealthIndicator>): Observable<Boolean>

    fun loadHealthIndicators(): Single<List<HealthIndicator>>
}