package com.example.hector.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hector.data.database.healthIndicators.HealthIndicator
import com.example.hector.data.database.healthIndicators.HealthIndicatorsDao
import com.example.hector.data.database.notifications.Notification
import com.example.hector.data.database.notifications.NotificationsDao

@Database(entities = [(Notification::class), (HealthIndicator::class)], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun notificationsDao(): NotificationsDao

    abstract fun healthIndicatorDao(): HealthIndicatorsDao
}