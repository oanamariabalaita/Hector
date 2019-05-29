package com.example.hector.data.local.healthIndicators

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HealthIndicatorsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(healthIndicators: List<HealthIndicator>)

    @Query("SELECT * FROM indicators WHERE is_selected = 'true' ")
    fun loadSelectedIndicators() : List<HealthIndicator>

    @Query("SELECT * FROM indicators")
    fun loadAll(): List<HealthIndicator>
}