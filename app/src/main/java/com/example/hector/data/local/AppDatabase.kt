package com.example.hector.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hector.data.local.healthIndicators.HealthIndicator
import com.example.hector.data.local.healthIndicators.HealthIndicatorsDao
import com.example.hector.data.local.notifications.Notification
import com.example.hector.data.local.notifications.NotificationsDao
import com.example.hector.data.local.users.User
import com.example.hector.data.local.users.UsersDao

@Database(entities = [(Notification::class), (HealthIndicator::class), (User::class)], version = 1)
abstract class AppDatabase : RoomDatabase(){

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "appdata.db"
                    )
                        .build()
                }
            }
            return INSTANCE as AppDatabase
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

    abstract fun notificationsDao(): NotificationsDao

    abstract fun healthIndicatorDao(): HealthIndicatorsDao

    abstract fun usersDao(): UsersDao
}