package com.mickeycj.restcountries

import io.reactivex.Single

import com.mickeycj.domain.models.Country
import com.mickeycj.domain.models.Currency
import com.mickeycj.domain.models.Language

import com.mickeycj.restcountries.states.CountriesState

/**
 * Object for providing mock data.
 */
object MockData {

    private val _country1 = Country(
        "https://restcountries.eu/data/usa.svg",
        "United States of America",
        "United States",
        "USA",
        "Washington, D.C.",
        "American",
        listOf(Language("English", "English", "eng")),
        listOf(Currency("United States dollar", "$", "USD")),
        listOf(
            "CAN",
            "MEX"
        ),
        "Americas",
        38.0f,
        -97.0f,
        9629091f,
        323947000,
        48.0f
    )
    private val _country2 = Country(
        "https://restcountries.eu/data/can.svg",
        "Canada",
        "Canada",
        "CAN",
        "Ottawa",
        "Canadian",
        listOf(
            Language("English", "English", "eng"),
            Language("French", "français", "fra")
        ),
        listOf(Currency("Canadian dollar", "$", "CAN")),
        listOf(
            "USA"
        ),
        "Americas",
        60.0f,
        -95.0f,
        9984670f,
        36155487,
        32.6f
    )
    private val _country3 = Country(
        "https://restcountries.eu/data/mex.svg",
        "Mexico",
        "México",
        "MEX",
        "Mexico City",
        "Mexican",
        listOf(Language("Spanish", "Español", "spa")),
        listOf(Currency("Mexican peso", "$", "MXN")),
        listOf(
            "BLZ",
            "GTM",
            "USA"
        ),
        "Americas",
        23.0f,
        -102.0f,
        1964375f,
        122273473,
        47.0f
    )
    private val _country4 = Country(
        "https://restcountries.eu/data/fra.svg",
        "France",
        "France",
        "FRA",
        "Paris",
        "French",
        listOf(Language("French", "français", "fra")),
        listOf(Currency("Euro", "€", "EUR")),
        listOf(
            "AND",
            "BEL",
            "DEU",
            "ITA",
            "LUX",
            "MCO",
            "ESP",
            "CHE"
        ),
        "Europe",
        46.0f,
        2.0f,
        640679f,
        66710000,
        32.7f
    )
    private val _country5 = Country(
        "https://restcountries.eu/data/tha.svg",
        "Thailand",
        "ประเทศไทย",
        "THA",
        "Bangkok",
        "Thai",
        listOf(Language("Thai", "ไทย", "tha")),
        listOf(Currency("Thai baht", "฿", "THB")),
        listOf(
            "MMR",
            "KHM",
            "LAO",
            "MYS"
        ),
        "Asia",
        15.0f,
        100.0f,
        513129f,
        65327652,
        40.0f
    )
    private val _countries = listOf(_country1, _country2, _country3, _country4, _country5)

    private val _countryState1 = CountriesState.Country(
        "https://restcountries.eu/data/usa.svg",
        "USA"
    )
    private val _countryState2 = CountriesState.Country(
        "https://restcountries.eu/data/can.svg",
        "CAN"
    )
    private val _countryState3 = CountriesState.Country(
        "https://restcountries.eu/data/mex.svg",
        "MEX"
    )
    private val _countryState4 = CountriesState.Country(
        "https://restcountries.eu/data/fra.svg",
        "FRA"
    )
    private val _countryState5 = CountriesState.Country(
        "https://restcountries.eu/data/tha.svg",
        "THA"
    )
    private val _region1 = CountriesState.Region(
        "Americas",
        listOf(_countryState1, _countryState2, _countryState3)
    )
    private val _region2 = CountriesState.Region(
        "Europe",
        listOf(_countryState4)
    )
    private val _region3 = CountriesState.Region(
        "Asia",
        listOf(_countryState5)
    )
    private val _countriesState = CountriesState(
        listOf(_region1, _region2, _region3)
    )

    val countries: List<Country> get() = _countries
    val countriesFromUseCase: Single<List<Country>> get() = Single.just(_countries)

    val countriesState: CountriesState get() = _countriesState
}
