package com.learning.catfact.presentation.di.core

import com.learning.catfact.domain.repository.BreedRepository
import com.learning.catfact.domain.usecases.GetBreedUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetBreedUseCase(breedRepository: BreedRepository): GetBreedUseCase {
        return GetBreedUseCase(breedRepository)
    }

}