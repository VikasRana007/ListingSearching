package com.learning.catfact.presentation.di.core

import com.learning.catfact.data.repository.BreedRepositoryImpl
import com.learning.catfact.data.repository.datasource.BreedCacheDataSource
import com.learning.catfact.data.repository.datasource.BreedLocalDataSource
import com.learning.catfact.data.repository.datasource.BreedRemoteDataSource
import com.learning.catfact.domain.repository.BreedRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideBreedRepository(
        breedRemoteDataSource: BreedRemoteDataSource,
        breedLocalDataSource: BreedLocalDataSource,
        breedCacheDataSource: BreedCacheDataSource
    ): BreedRepository {
        return BreedRepositoryImpl(
            breedRemoteDataSource,
            breedLocalDataSource,
            breedCacheDataSource
        )

    }
}