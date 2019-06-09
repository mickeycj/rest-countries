package com.mickeycj.data.repository

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

import io.reactivex.Maybe
import io.reactivex.Single

import com.mickeycj.domain.models.Country

import com.mickeycj.data.MockData
import com.mickeycj.data.mappers.CountryMapper

/**
 * Spek tests for remote Country repository.
 */
class CountryRepositorySpec : Spek({

    describe("Country Repository") {

        val restCountriesApi by memoized { mockk<RestCountriesApi>() }
        val countryMapper by memoized { mockk<CountryMapper>() }
        val countryRepository by memoized { CountryRepository(restCountriesApi, countryMapper) }

        context("Getting countries from REST Countries API") {

            val mockCountriesFromApi = MockData.countriesFromApi
            val mockCountryData = MockData.countryData
            val mockCountry = MockData.country

            lateinit var result: Single<List<Country>>

            beforeEach {
                every { restCountriesApi.getCountries() } returns mockCountriesFromApi
                every { countryMapper.toModel(mockCountryData) } returns mockCountry

                result = countryRepository.getCountries()
            }
            it("Should complete the API call without any errors") {
                verify(exactly = 1) { restCountriesApi.getCountries() }
                confirmVerified(restCountriesApi)

                result.test()
                    .assertComplete()
                    .assertNoErrors()
            }
            it("Should call the corresponding mapper") {
                verify(exactly = 3) { countryMapper.toModel(mockCountryData) }
                confirmVerified(countryMapper)
            }
        }

        context("Getting country by code from REST Countries API") {

            val code = "USA"
            val mockCountryFromApi = MockData.countryFromApi
            val mockCountryData = MockData.countryData
            val mockCountry = MockData.country

            lateinit var result: Maybe<Country>

            beforeEach {
                every { restCountriesApi.getCountryByCode(code) } returns mockCountryFromApi
                every { countryMapper.toModel(mockCountryData) } returns mockCountry

                result = countryRepository.getCountry(code)
            }
            it("Should complete the API call without any errors") {
                verify(exactly = 1) { restCountriesApi.getCountryByCode(code) }
                confirmVerified(restCountriesApi)

                result.test()
                    .assertComplete()
                    .assertNoErrors()
            }
            it("Should call the corresponding mapper") {
                verify(exactly = 1) { countryMapper.toModel(mockCountryData) }
                confirmVerified(countryMapper)
            }
        }
    }
})
