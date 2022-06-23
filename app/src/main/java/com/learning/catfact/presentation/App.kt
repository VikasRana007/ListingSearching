package com.learning.catfact.presentation

import android.app.Application
import com.learning.catfact.BuildConfig
import com.learning.catfact.presentation.di.Injector
import com.learning.catfact.presentation.di.breed.BreedSubComponent
import com.learning.catfact.presentation.di.core.*

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(80))
            .build()
    }

    override fun createBreedSubComponent(): BreedSubComponent {
        return appComponent.breedSubComponent().create()
    }
}