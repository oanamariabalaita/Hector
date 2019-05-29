package com.example.hector.data.local.healthIndicators

import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class HealthIndicatorsRepository @Inject constructor(private val healthIndicatorsDao: HealthIndicatorsDao) : HealthIndicatorsRepo{

    override fun isHealthIndicatorsRepoEmpty(): Observable<Boolean> = Observable.just(healthIndicatorsDao.loadAll().isEmpty())

    override fun insertHealthIndicators(healthIndicators: List<HealthIndicator>): Observable<Boolean> {

        healthIndicatorsDao.insertAll(healthIndicators)
        return Observable.just(true)
    }

    override fun loadHealthIndicators(): Single<List<HealthIndicator>> = Single.fromCallable {healthIndicatorsDao.loadSelectedIndicators() }

}