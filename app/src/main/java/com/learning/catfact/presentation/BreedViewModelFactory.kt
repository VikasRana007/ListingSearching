package com.learning.catfact.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.learning.catfact.domain.usecases.GetBreedUseCase

class BreedViewModelFactory(private val getBreedUseCase: GetBreedUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BreedViewModel(getBreedUseCase) as T
    }
}