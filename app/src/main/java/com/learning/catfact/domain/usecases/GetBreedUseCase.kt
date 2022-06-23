package com.learning.catfact.domain.usecases

import com.learning.catfact.data.model.Data
import com.learning.catfact.domain.repository.BreedRepository

class GetBreedUseCase(private val breedRepository: BreedRepository) {
    // Required a function which can return the list of breeds instances
    suspend fun execute(): List<Data>? = breedRepository.getBreed()
}