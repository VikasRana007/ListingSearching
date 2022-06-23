package com.learning.catfact.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.learning.catfact.data.db.BreedDao
import com.learning.catfact.data.db.BreedDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideBreedDataBase(context: Context): BreedDatabase {
        return Room.databaseBuilder(context, BreedDatabase::class.java, "breed_database")
            .build()
    }

    @Singleton
    @Provides
    fun provideBreedDao(breedDatabase: BreedDatabase): BreedDao {
        return breedDatabase.breedDao()
    }
}