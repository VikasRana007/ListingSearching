package com.learning.catfact.data.repository.datasourceImpl

import com.learning.catfact.data.api.BreedServices
import com.learning.catfact.data.model.BreedList
import com.learning.catfact.data.repository.datasource.BreedRemoteDataSource
import retrofit2.Response

class BreedRemoteDataSourceImpl(
    private val breedServices: BreedServices,
    private val limit_value: Int
) : BreedRemoteDataSource {
    // here we are writing codes to invoke the getBreed() of BreedServices
    override suspend fun getBreed(): Response<BreedList> = breedServices.getBreedData(limit_value)

}