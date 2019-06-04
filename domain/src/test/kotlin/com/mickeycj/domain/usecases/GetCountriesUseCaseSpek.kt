package com.mickeycj.domain.usecases

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

import com.mickeycj.domain.Faker
import com.mickeycj.domain.contracts.CountryRepository

/**
 * Spek tests for getting countries from the repository.
 */
object GetCountriesUseCaseSpek : Spek({

    describe("Get Countries Use Case") {

        val countryRepository by memoized { mockk<CountryRepository>() }

        val getCountriesUseCase by memoized { GetCountriesUseCase(countryRepository) }

        context("When getting countries from the repository") {
            it("It should return a list of all countries") {
                every { countryRepository.getCountries() } returns Faker.getCountries()

                getCountriesUseCase.execute()

                verify { countryRepository.getCountries() }

                confirmVerified(countryRepository)
            }
        }
    }
})
