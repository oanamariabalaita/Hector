package com.example.hector.data.local.indicator

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HealthIndicatorsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(healthIndicators: List<HealthIndicator>)

    @Query("SELECT * FROM health_indicator WHERE selected = 'true' ")
    fun loadSelectedIndicators(): List<HealthIndicator>

    @Query("SELECT * FROM health_indicator")
    fun loadAll(): List<HealthIndicator>
}