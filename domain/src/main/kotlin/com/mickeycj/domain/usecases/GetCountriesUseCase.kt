package com.mickeycj.domain.usecases

import io.reactivex.Single

import com.mickeycj.domain.contracts.CountryRepository
import com.mickeycj.domain.models.Country

/**
 * Get all countries from the repository.
 */
class GetCountriesUseCase(private val countryRepository: CountryRepository) {

    fun execute(): Single<List<Country>> = TODO()
}
