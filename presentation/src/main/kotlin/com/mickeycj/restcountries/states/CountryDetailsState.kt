package com.mickeycj.restcountries.states

data class CountryDetailsState(
    val flagUrl: String = "",
    val name: String = "",
    val code: String = "",
    val region: String = "",
    val capital: String = "",
    val demonym: String = "",
    val languages: String = "",
    val currencies: String = "",
    val latitude: Float = 0.0f,
    val longitude: Float = 0.0f,
    val area: Float = 0.0f,
    val population: Int = 0,
    val giniIndex: Float = 0.0f,
    val borders: List<CountriesState.Country> = listOf()
)
