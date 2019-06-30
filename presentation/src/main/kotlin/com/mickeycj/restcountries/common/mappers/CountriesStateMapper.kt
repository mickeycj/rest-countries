package com.mickeycj.restcountries.common.mappers

import com.mickeycj.domain.models.Country

import com.mickeycj.restcountries.common.base.StateMapper
import com.mickeycj.restcountries.common.states.CountriesState

/**
 * State mapper for converting list of Country models to Countries state.
 */
class CountriesStateMapper :
    StateMapper<List<Country>, CountriesState> {

    override fun toState(from: List<Country>): CountriesState = TODO()
}
