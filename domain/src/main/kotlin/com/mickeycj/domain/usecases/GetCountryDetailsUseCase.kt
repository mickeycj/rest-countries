package com.mickeycj.domain.usecases

import io.reactivex.Maybe

import com.mickeycj.domain.contracts.CountryRepository
import com.mickeycj.domain.models.Country

/**
 * Get country details from the repository.
 */
class GetCountryDetailsUseCase(private val countryRepository: CountryRepository) {

    fun execute(code: String): Maybe<Country> = countryRepository.getCountry(code)
}
