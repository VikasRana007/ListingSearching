package com.learning.catfact.presentation.di.core

import com.learning.catfact.data.db.BreedDao
import com.learning.catfact.data.repository.datasource.BreedLocalDataSource
import com.learning.catfact.data.repository.datasourceImpl.BreedLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideBreedLocalDataSource(breedDao: BreedDao): BreedLocalDataSource {
        return BreedLocalDataSourceImpl(breedDao)
    }
}