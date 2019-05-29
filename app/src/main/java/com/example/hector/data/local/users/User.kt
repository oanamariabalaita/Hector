package com.example.hector.data.local.users

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class User(
    @Expose
    @PrimaryKey(autoGenerate = true)
    var id: Long,

    @Expose
    @SerializedName("user_name")
    @ColumnInfo(name = "user_name")
    var userName: String,

    @Expose
    @SerializedName("user_year")
    @ColumnInfo(name = "user_year")
    var userBirthYear: Int,

    @Expose
    @SerializedName("user_height")
    @ColumnInfo(name = "user_height")
    var userHeight: Float,

    @Expose
    @SerializedName("user_step")
    @ColumnInfo(name = "user_step")
    var userStep: Float
)
