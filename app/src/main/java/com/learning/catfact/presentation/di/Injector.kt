package com.learning.catfact.presentation.di

import com.learning.catfact.presentation.di.breed.BreedSubComponent

interface Injector {
    fun createBreedSubComponent(): BreedSubComponent
}