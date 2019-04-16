package com.example.hector.data.database.healthIndicators

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "indicators")
data class HealthIndicator (

    @Expose
    @PrimaryKey(autoGenerate = true)
    var id: Long,

    @Expose
    @SerializedName("indicator_name")
    @ColumnInfo(name = "indicator_name")
    var indicatorName: String,

    @Expose
    @SerializedName("indicator_img_url")
    @ColumnInfo(name = "indicator_img_url")
    var imgUrl: String?,

    @Expose
    @SerializedName("indicator_description")
    @ColumnInfo(name = "indicator_description")
    var descriptionText: String?,

    @Expose
    @SerializedName("indicator_descriptive_value")
    @ColumnInfo(name = "ind_descriptive_value")
    var descriptiveVal: String?,

    @Expose
    @SerializedName("indicator_quantitative_value")
    @ColumnInfo(name = "ind_quantitative_value")
    var quantitativeVal: Int?,

    @Expose
    @SerializedName("is_selected")
    @ColumnInfo(name = "is_selected")
    var isSelected: Boolean?

)