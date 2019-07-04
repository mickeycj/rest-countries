package com.mickeycj.restcountries.common.mappers

import org.junit.Test

import org.assertj.core.api.Assertions.assertThat

import com.mickeycj.restcountries.MockData

/**
 * Spec for Countries state mapper.
 */
class CountriesStateMapperSpec {

    private val countriesStateMapper = CountriesStateMapper()

    @Test
    fun `Countries State Mapper should return the correct state mapping when called`() {
        val mockCountries = MockData.countries
        val mockCountriesState = MockData.countriesState

        val result = countriesStateMapper.toState(mockCountries)

        assertThat(result).isEqualTo(mockCountriesState)
    }
}
