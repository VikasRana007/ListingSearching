package com.learning.catfact.presentation.di.core

import android.content.Context
import com.learning.catfact.presentation.di.breed.BreedSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [BreedSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}