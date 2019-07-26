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
    @SerializedName("userName")
    @ColumnInfo(name = "user_name")
    var userName: String,

    @Expose
    @SerializedName("userGender")
    @ColumnInfo(name = "user_gender")
    var userGender: String,

    @Expose
    @SerializedName("userBirthYear")
    @ColumnInfo(name = "user_birth_year")
    var userBirthYear: Int,

    @Expose
    @SerializedName("userHeight")
    @ColumnInfo(name = "user_height")
    var userHeight: Float,

    @Expose
    @SerializedName("userWeight")
    @ColumnInfo(name = "user_weight")
    var userWeight: Float,

    @Expose
    @SerializedName("activityLevel")
    @ColumnInfo(name = "activity_level")
    var userActivityLevel: String


)
