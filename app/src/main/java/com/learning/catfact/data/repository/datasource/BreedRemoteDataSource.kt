package com.learning.catfact.data.repository.datasource

import com.learning.catfact.data.model.BreedList
import retrofit2.Response

interface BreedRemoteDataSource {
    suspend fun getBreed(): Response<BreedList>
}