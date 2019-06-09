package com.mickeycj.domain.usecases

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

import com.mickeycj.domain.MockData
import com.mickeycj.domain.contracts.CountryRepository

/**
 * Spek tests for getting countries from the repository.
 */
object GetCountriesUseCaseSpec : Spek({

    describe("Get Countries Use Case") {

        val countryRepository by memoized { mockk<CountryRepository>() }
        val getCountriesUseCase by memoized { GetCountriesUseCase(countryRepository) }

        context("Getting countries from the repository") {

            val mockCountries = MockData.countries

            beforeEach {
                every { countryRepository.getCountries() } returns mockCountries

                getCountriesUseCase.execute()
            }
            it("Should request for the list of all countries from the repository") {
                verify(exactly = 1) { countryRepository.getCountries() }
                confirmVerified(countryRepository)
            }
        }
    }
})
