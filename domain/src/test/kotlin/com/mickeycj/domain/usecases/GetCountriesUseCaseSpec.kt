package com.mickeycj.domain.usecases

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

import io.reactivex.observers.TestObserver

import com.mickeycj.domain.MockData
import com.mickeycj.domain.contracts.CountryRepository
import com.mickeycj.domain.models.Country

/**
 * Spek tests for getting countriesFromRepository from the repository.
 */
object GetCountriesUseCaseSpec : Spek({

    describe("Get Countries Use Case") {

        val countryRepository by memoized { mockk<CountryRepository>() }
        val getCountriesUseCase by memoized { GetCountriesUseCase(countryRepository) }

        context("Getting countries from the repository") {

            val mockCountriesFromRepository = MockData.countriesFromRepository
            val mockCountries = MockData.countries

            lateinit var testObserver: TestObserver<List<Country>>

            beforeEach {
                every { countryRepository.getCountries() } returns mockCountriesFromRepository

                testObserver = getCountriesUseCase.execute().test()
            }
            it("Should request for the list of all countries from the repository") {
                verify(exactly = 1) { countryRepository.getCountries() }
                confirmVerified(countryRepository)
            }
            it("Should return the correct list of countries from the repository") {
                testObserver.assertResult(mockCountries)
            }
            afterEach {
                testObserver.dispose()
            }
        }
    }
})
