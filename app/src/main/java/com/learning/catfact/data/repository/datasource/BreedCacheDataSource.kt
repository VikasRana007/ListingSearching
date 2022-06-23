package com.learning.catfact.data.repository.datasource

import com.learning.catfact.data.model.Data

interface BreedCacheDataSource {
    suspend fun getBreedFromCache(): List<Data>

    suspend fun saveBreedToCache(breed: List<Data>)
}