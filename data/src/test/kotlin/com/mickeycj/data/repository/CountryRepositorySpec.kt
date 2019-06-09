package com.mickeycj.data.repository

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifyAll

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

        context("When getting countries from REST Countries API") {
            it("It should complete the API call without any errors") {
                every { restCountriesApi.getCountries() } returns MockData.countriesFromApi
                every {
                    countryMapper.toModel(MockData.countryData)
                } returns MockData.country

                val result = countryRepository.getCountries()

                verify { restCountriesApi.getCountries() }
                verify(exactly = 3) { countryMapper.toModel(MockData.countryData) }
                confirmVerified(restCountriesApi, countryMapper)

                result.test()
                    .assertComplete()
                    .assertNoErrors()
            }
        }

        context("When getting country by code from REST Countries API") {
            it("It should complete the API call without any errors") {
                val code = "USA"

                every { restCountriesApi.getCountryByCode(code) } returns MockData.countryFromApi
                every {
                    countryMapper.toModel(MockData.countryData)
                } returns MockData.country

                val result = countryRepository.getCountry(code)

                verifyAll {
                    restCountriesApi.getCountryByCode(code)
                    countryMapper.toModel(MockData.countryData)
                }

                result.test()
                    .assertComplete()
                    .assertNoErrors()
            }
        }
    }
})
