package com.mickeycj.restcountries.common.mappers

import com.mickeycj.domain.models.Country

import com.mickeycj.restcountries.common.base.StateMapper
import com.mickeycj.restcountries.common.states.CountriesState
import com.mickeycj.restcountries.common.states.CountryDetailsState

/**
 * State mapper for converting Country model to Country Details state.
 */
class CountryDetailsStateMapper : StateMapper<Country, CountryDetailsState> {

    override fun toState(from: Country): CountryDetailsState = CountryDetailsState(
        from.flagUrl,
        from.name,
        from.code,
        from.region,
        from.capital,
        from.demonym,
        from.languages.joinToString(",") { it.name },
        from.currencies.joinToString(",") { "${it.code}(${it.symbol})" },
        from.latitude,
        from.longitude,
        from.area,
        from.population,
        from.giniIndex,
        from.borders.map {
            CountriesState.Country(
                from.flagUrl.replace(from.code.toLowerCase(), it.toLowerCase()),
                it
            )
        }
    )
}
