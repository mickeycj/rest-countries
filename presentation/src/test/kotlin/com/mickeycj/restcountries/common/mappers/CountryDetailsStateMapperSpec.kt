package com.mickeycj.restcountries.common.mappers

import org.junit.Test

import org.assertj.core.api.Assertions.assertThat

import com.mickeycj.restcountries.MockData

/**
 * Spec for Country Details state mapper.
 */
class CountryDetailsStateMapperSpec {

    private val countryDetailsStateMapper = CountryDetailsStateMapper()

    @Test
    fun `Country Details State Mapper should return the correct state mapping when called`() {
        val mockCountryDetails = MockData.countryDetails
        val mockCountryDetailsState = MockData.countryDetailsState

        val result = countryDetailsStateMapper.toState(mockCountryDetails)

        assertThat(result).isEqualTo(mockCountryDetailsState)
    }
}
