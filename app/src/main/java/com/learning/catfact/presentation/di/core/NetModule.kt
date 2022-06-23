package com.learning.catfact.presentation.di.core

import com.learning.catfact.data.api.BreedServices
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * This is the network module help to get the data from
 * web as well as it provides to dependencies
 * Retrofit Instance & BreedService Instance
 */

@Module
class NetModule(private val base_url: String) {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(base_url)
            .build()
    }

    @Singleton
    @Provides
    fun provideBreedService(retrofit: Retrofit): BreedServices {
        return retrofit.create(BreedServices::class.java)
    }
}