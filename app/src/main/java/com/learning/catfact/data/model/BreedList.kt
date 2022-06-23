package com.learning.catfact.data.model

import com.google.gson.annotations.SerializedName

data class BreedList(
    @SerializedName("data")
    val `data`: List<Data>,
)