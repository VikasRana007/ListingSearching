package com.learning.catfact.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.learning.catfact.data.model.Data
import com.learning.catfact.domain.usecases.GetBreedUseCase

class BreedViewModel(private val getBreedUseCase: GetBreedUseCase) : ViewModel() {

    fun getBreed(): LiveData<List<Data>?> = liveData {
        val breedList: List<Data>? = getBreedUseCase.execute()
        emit(breedList)
    }
}