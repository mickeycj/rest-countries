package com.mickeycj.restcountries.mappers

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

import org.assertj.core.api.Assertions.assertThat

import com.mickeycj.restcountries.MockData
import com.mickeycj.restcountries.states.CountriesState

/**
 * Spek tests for Countries state mapper.
 */
class CountriesStateMapperSpec : Spek({

    describe("Countries State Mapper") {

        val countriesStateMapper by memoized { CountriesStateMapper() }

        context("Mapping countries from use case to its corresponding countries state") {

            val mockCountries = MockData.countries
            val mockCountriesState = MockData.countriesState

            lateinit var result: CountriesState

            beforeEach {
                result = countriesStateMapper.toState(mockCountries)
            }
            it("Should return the correct state mapping") {
                assertThat(result).isEqualTo(mockCountriesState)
            }
        }
    }
})
