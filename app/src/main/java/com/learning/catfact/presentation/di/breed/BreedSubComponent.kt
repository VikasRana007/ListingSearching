package com.learning.catfact.presentation.di.breed

import com.learning.catfact.MainActivity
import dagger.Subcomponent

@BreedScope
@Subcomponent(modules = [BreedModule::class])
interface BreedSubComponent {

    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): BreedSubComponent
    }
}