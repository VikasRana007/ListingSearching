package com.learning.catfact.presentation.di.core

import com.learning.catfact.data.api.BreedServices
import com.learning.catfact.data.repository.datasource.BreedRemoteDataSource
import com.learning.catfact.data.repository.datasourceImpl.BreedRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val limit_value: Int) {

    @Singleton
    @Provides
    fun provideBreedRemoteDataSource(breedServices: BreedServices): BreedRemoteDataSource {
        return BreedRemoteDataSourceImpl(breedServices, limit_value)
    }
}