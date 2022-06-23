package com.learning.catfact.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "breeds_data")
data class Data(

    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @SerializedName("breed")
    val breed: String?,
    @SerializedName("coat")
    val coat: String?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("origin")
    val origin: String?,
    @SerializedName("pattern")
    val pattern: String?
)