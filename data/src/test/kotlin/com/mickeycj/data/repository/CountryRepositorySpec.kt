package com.mickeycj.data.repository

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

import io.reactivex.observers.TestObserver

import com.mickeycj.domain.contracts.Mapper
import com.mickeycj.domain.models.Country

import com.mickeycj.data.MockData
import com.mickeycj.data.models.CountryData

/**
 * Spek tests for remote Country repository.
 */
class CountryRepositorySpec : Spek({

    describe("Country Repository") {

        val restCountriesApi by memoized { mockk<RestCountriesApi>() }
        val countryMapper by memoized { mockk<Mapper<CountryData, Country>>() }
        val countryRepository by memoized { CountryRepository(restCountriesApi, countryMapper) }

        context("Getting countries from REST Countries API") {

            val mockCountriesFromApi = MockData.countriesFromApi
            val mockCountryData = MockData.countryData
            val mockCountry = MockData.country

            lateinit var testObserver: TestObserver<List<Country>>

            beforeEach {
                every { restCountriesApi.getCountries() } returns mockCountriesFromApi
                every { countryMapper.toModel(mockCountryData) } returns mockCountry

                testObserver = countryRepository.getCountries().test()
            }
            it("Should complete the API call without any errors") {
                testObserver.assertComplete().assertNoErrors()

                verify(exactly = 1) { restCountriesApi.getCountries() }
                confirmVerified(restCountriesApi)
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

            lateinit var testObserver: TestObserver<Country>

            beforeEach {
                every { restCountriesApi.getCountryByCode(code) } returns mockCountryFromApi
                every { countryMapper.toModel(mockCountryData) } returns mockCountry

                testObserver = countryRepository.getCountry(code).test()
            }
            it("Should complete the API call without any errors") {
                testObserver.assertComplete().assertNoErrors()

                verify(exactly = 1) { restCountriesApi.getCountryByCode(code) }
                confirmVerified(restCountriesApi)
            }
            it("Should call the corresponding mapper") {
                verify(exactly = 1) { countryMapper.toModel(mockCountryData) }
                confirmVerified(countryMapper)
            }
        }
    }
})
