package com.learning.catfact.presentation.di.core

import com.learning.catfact.presentation.di.breed.BreedSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class,
        NetModule::class,
        DataBaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class]
)
interface AppComponent {
    fun breedSubComponent(): BreedSubComponent.Factory
}