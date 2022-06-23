package com.learning.catfact.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.learning.catfact.data.model.Data

@Database(entities = [Data::class], version = 1, exportSchema = false)
abstract class BreedDatabase : RoomDatabase() {
    abstract fun breedDao(): BreedDao
}