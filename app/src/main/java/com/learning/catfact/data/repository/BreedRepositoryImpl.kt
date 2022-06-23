package com.learning.catfact.data.repository

import android.util.Log
import com.learning.catfact.data.model.BreedList
import com.learning.catfact.data.model.Data
import com.learning.catfact.data.repository.datasource.BreedCacheDataSource
import com.learning.catfact.data.repository.datasource.BreedLocalDataSource
import com.learning.catfact.data.repository.datasource.BreedRemoteDataSource
import com.learning.catfact.domain.repository.BreedRepository
import retrofit2.Response

// This class is depends on the data sources so this class need them
class BreedRepositoryImpl(
    private val breedRemoteDataSource: BreedRemoteDataSource,
    private val breedLocalDataSource: BreedLocalDataSource,
    private val breedCacheDataSource: BreedCacheDataSource
) : BreedRepository {
    override suspend fun getBreed(): List<Data>? {
        return getBreedFromCache()
    }

    suspend fun getBreedFromAPI(): List<Data> {
        lateinit var breedList: List<Data>
        try {
            val response: Response<BreedList> = breedRemoteDataSource.getBreed()
            val body: BreedList? = response.body()
            if (body != null) {
                breedList = body.data
            }
        } catch (exception: Exception) {
            Log.i("My Tag", exception.message.toString())
        }
        return breedList
    }


    suspend fun getBreedFromDB(): List<Data> {
        lateinit var breedList: List<Data>
        try {
            breedList = breedLocalDataSource.getBreedFromDB()
            if (breedList.size > 0) {
                return breedList
            } else {
                breedList = getBreedFromAPI()
                breedLocalDataSource.saveBreedToDB(breedList)
            }
        } catch (exception: Exception) {
            Log.i("My Tag", exception.message.toString())
        }
        return breedList
    }


    suspend fun getBreedFromCache(): List<Data> {
        lateinit var breedList: List<Data>
        try {
            breedList = breedCacheDataSource.getBreedFromCache()
            if (breedList.size > 0) {
                return breedList
            } else {
                breedList = getBreedFromDB()
                breedCacheDataSource.saveBreedToCache(breedList)
            }
        } catch (exception: Exception) {
            Log.i("My Tag", exception.message.toString())
        }
        return breedList
    }
}