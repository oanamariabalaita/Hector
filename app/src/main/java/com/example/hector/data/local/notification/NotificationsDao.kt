package com.example.hector.data.local.notification

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NotificationsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(notifications: List<Notification>)

    @Query("SELECT * FROM notifications")
    fun loadAll(): List<Notification>

}