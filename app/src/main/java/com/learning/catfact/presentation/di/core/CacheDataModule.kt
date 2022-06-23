package com.learning.catfact.presentation.di.core

import com.learning.catfact.data.repository.datasource.BreedCacheDataSource
import com.learning.catfact.data.repository.datasourceImpl.BreedCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideBreedCacheDataSource(): BreedCacheDataSource {
        return BreedCacheDataSourceImpl()
    }
}