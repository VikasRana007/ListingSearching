package com.learning.catfact.presentation.di.breed

import com.learning.catfact.domain.usecases.GetBreedUseCase
import com.learning.catfact.presentation.BreedViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class BreedModule {

    @BreedScope
    @Provides
    fun provideBreedViewModelFactory(
        getBreedUseCase: GetBreedUseCase
    ): BreedViewModelFactory {
        return BreedViewModelFactory(getBreedUseCase)
    }
}