package com.example.hector.data.local.healthIndicators

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.sql.Timestamp

@Entity(tableName = "indicators")
data class HealthIndicator(

    @Expose
    @PrimaryKey(autoGenerate = true)
    @SerializedName("indicatorId")
    @ColumnInfo(name = "indicator_id")
    var id: Long,

    @Expose
    @SerializedName("name")
    @ColumnInfo(name = "name")
    var indicatorName: String,

    @Expose
    @SerializedName("imgId")
    @ColumnInfo(name = "img_id")
    var imgId: String? = null,

    @Expose
    @SerializedName("descriptiveVal")
    @ColumnInfo(name = "descriptive_val")
    var descriptiveVal: String? = null,

    @Expose
    @SerializedName("quantitativeVal")
    @ColumnInfo(name = "quantitative_val")
    var quantitativeVal: Float? = null,

    @Expose
    @SerializedName("unit")
    @ColumnInfo(name = "unit")
    var unit: String? = null,

    @Expose
    @SerializedName("recordedAt")
    @ColumnInfo(name = "recorded_at")
    var recordedAt: Timestamp? = null,

    @Expose
    @SerializedName("isSelected")
    @ColumnInfo(name = "is_selected")
    var isSelected: Boolean? = null

)