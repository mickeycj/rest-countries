package com.mickeycj.domain

import io.reactivex.Maybe
import io.reactivex.Single

import com.mickeycj.domain.models.Country
import com.mickeycj.domain.models.Currency
import com.mickeycj.domain.models.Language

/**
 * Object for providing mock data.
 */
object MockData {

    private val _country = Country(
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
        9629091.0f,
        323947000,
        48.0f
    )
    private val _countries = List(3) { _country }

    val countriesFromRepository: Single<List<Country>> get() = Single.just(_countries)
    val countryDetailsFromRepository: Maybe<Country> get() = Maybe.just(_country)

    val countries: List<Country> get() = _countries
    val countryDetails: Country get() = _country
}
