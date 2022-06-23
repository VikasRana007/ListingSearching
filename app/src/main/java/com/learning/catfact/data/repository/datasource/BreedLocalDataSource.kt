package com.learning.catfact.data.repository.datasource

import com.learning.catfact.data.model.Data

interface BreedLocalDataSource {
    suspend fun getBreedFromDB(): List<Data>
    suspend fun saveBreedToDB(breed: List<Data>)
}