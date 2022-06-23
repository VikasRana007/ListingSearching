package com.learning.catfact.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.learning.catfact.data.model.Data

@Dao
interface BreedDao {

    // To insert data into Room Data base
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveBreed(breed: List<Data>)

    // To get data from Room Data base
    @Query("SELECT * FROM breeds_data")
    suspend fun getBreed(): List<Data>
}