package com.mickeycj.restcountries.common.mappers

import com.mickeycj.domain.models.Country

import com.mickeycj.restcountries.common.base.StateMapper
import com.mickeycj.restcountries.common.states.CountryDetailsState

/**
 * State mapper for converting Country model to Country Details state.
 */
class CountryDetailsStateMapper :
    StateMapper<Country, CountryDetailsState> {

    override fun toState(from: Country): CountryDetailsState = TODO()
}
