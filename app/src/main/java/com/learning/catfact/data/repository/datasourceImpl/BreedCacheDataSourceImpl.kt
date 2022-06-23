package com.learning.catfact.data.repository.datasourceImpl

import com.learning.catfact.data.model.Data
import com.learning.catfact.data.repository.datasource.BreedCacheDataSource

class BreedCacheDataSourceImpl : BreedCacheDataSource {
    private var breedList = ArrayList<Data>()
    override suspend fun getBreedFromCache(): List<Data> {
        return breedList
    }

    override suspend fun saveBreedToCache(breed: List<Data>) {
        breedList.clear()
        breedList = ArrayList(breed)
    }
}