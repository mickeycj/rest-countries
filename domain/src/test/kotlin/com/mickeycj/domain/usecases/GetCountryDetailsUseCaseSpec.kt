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
 * Spek tests for getting country details from the repository.
 */
object GetCountryDetailsUseCaseSpec : Spek({

    describe("Get Country Details") {

        val countryRepository by memoized { mockk<CountryRepository>() }
        val getCountryDetailsUseCase by memoized { GetCountryDetailsUseCase(countryRepository) }

        context("Getting country details from the repository") {

            val code = "USA"
            val mockCountryDetailsFromRepository = MockData.countryDetailsFromRepository
            val mockCountryDetails = MockData.countryDetails

            lateinit var testObserver: TestObserver<Country>

            beforeEach {
                every { countryRepository.getCountry(code) } returns mockCountryDetailsFromRepository

                testObserver = getCountryDetailsUseCase.execute(code).test()
            }
            it("Should request for the specified country details from the repository") {
                verify(exactly = 1) { countryRepository.getCountry(code) }
                confirmVerified(countryRepository)
            }
            it("Should return the correct country details from the repository") {
                testObserver.assertResult(mockCountryDetails)
            }
            afterEach {
                testObserver.dispose()
            }
        }
    }
})
