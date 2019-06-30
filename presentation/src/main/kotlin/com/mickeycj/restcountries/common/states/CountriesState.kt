package com.mickeycj.restcountries.common.states

data class CountriesState(
    val regions: List<Region> = listOf()
) {

    data class Region(
        val name: String = "",
        val countries: List<Country> = listOf()
    )

    data class Country(
        val flagUrl: String = "",
        val code: String = ""
    )
}
