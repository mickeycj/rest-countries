package com.mickeycj.restcountries.mappers

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

import org.assertj.core.api.Assertions.assertThat

import com.mickeycj.restcountries.MockData
import com.mickeycj.restcountries.states.CountryDetailsState

/**
 * Spek tests for Country Details state mapper.
 */
class CountryDetailsStateMapperSpec : Spek({

    describe("Country Details State Mapper") {

        val countryDetailsStateMapper by memoized { CountryDetailsStateMapper() }

        context("Mapping country from use case to its corresponding country details state") {

            val mockCountryDetails = MockData.countryDetails
            val mockCountryDetailsState = MockData.countryDetailsState

            lateinit var result: CountryDetailsState

            beforeEach {
                result = countryDetailsStateMapper.toState(mockCountryDetails)
            }
            it("Should return the correct state mapping") {
                assertThat(result).isEqualTo(mockCountryDetailsState)
            }
        }
    }
})
