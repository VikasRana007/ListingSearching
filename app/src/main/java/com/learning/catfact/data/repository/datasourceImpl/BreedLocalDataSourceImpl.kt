package com.learning.catfact.data.repository.datasourceImpl

import com.learning.catfact.data.db.BreedDao
import com.learning.catfact.data.model.Data
import com.learning.catfact.data.repository.datasource.BreedLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BreedLocalDataSourceImpl(private val breedDao: BreedDao) : BreedLocalDataSource {
    override suspend fun getBreedFromDB(): List<Data> {
        return breedDao.getBreed()
    }

    override suspend fun saveBreedToDB(breed: List<Data>) {
        CoroutineScope(Dispatchers.IO).launch {
            breedDao.saveBreed(breed)
        }
    }
}