package com.example.hector.data.database.notifications

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "notifications")
data class Notification (

    @Expose
    @PrimaryKey(autoGenerate = true)
    var id: Long,

    @Expose
    @SerializedName("notification_text")
    @ColumnInfo(name = "notification_text")
    var notificationText: String,

    @Expose
    @SerializedName("notification_type")
    @ColumnInfo(name = "notification_type")
    var notificationType: String?,

    @Expose
    @SerializedName("received_at")
    @ColumnInfo(name = "received_at")
    var receivedAt: String?,

    @Expose
    @SerializedName("is_read")
    @ColumnInfo(name = "is_read")
    var isRead: Boolean?



)