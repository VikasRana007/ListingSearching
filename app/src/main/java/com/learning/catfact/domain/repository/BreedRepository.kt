package com.learning.catfact.domain.repository

import com.learning.catfact.data.model.Data

interface BreedRepository {

    // here we need to define an abstract function which returns a list of breeds & this should also be null safe
    suspend fun getBreed(): List<Data>?
}