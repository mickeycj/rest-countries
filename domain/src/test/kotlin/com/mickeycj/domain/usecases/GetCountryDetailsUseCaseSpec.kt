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
 * Spek tests for getting country details from the repository.
 */
object GetCountryDetailsUseCaseSpec : Spek({

    describe("Get Country Details") {

        val countryRepository by memoized { mockk<CountryRepository>() }
        val getCountryDetailsUseCase by memoized { GetCountryDetailsUseCase(countryRepository) }

        context("Getting country details from the repository") {

            val code = "USA"
            val mockCountryDetails = MockData.countryDetails

            beforeEach {
                every { countryRepository.getCountry(code) } returns mockCountryDetails

                getCountryDetailsUseCase.execute(code)
            }
            it("Should request for the specified country details from the repository") {
                verify(exactly = 1) { countryRepository.getCountry(code) }
                confirmVerified(countryRepository)
            }
        }
    }
})
