package com.learning.catfact.data.api

import com.learning.catfact.data.model.BreedList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//private val  limit_value:Int = 50
interface BreedServices {
    @GET("breeds")
    suspend fun getBreedData(@Query("limit") limit_value: Int): Response<BreedList>
}