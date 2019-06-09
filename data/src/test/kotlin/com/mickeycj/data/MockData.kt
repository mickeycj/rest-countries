package com.mickeycj.data

import io.reactivex.Maybe
import io.reactivex.Single

import com.mickeycj.domain.models.Country
import com.mickeycj.domain.models.Currency
import com.mickeycj.domain.models.Language

import com.mickeycj.data.models.CountryData
import com.mickeycj.data.models.CurrencyData
import com.mickeycj.data.models.LanguageData
import com.mickeycj.data.models.RegionalBlocData
import com.mickeycj.data.models.TranslationsData

/**
 * Object for providing mock data.
 */
object MockData {

    private val _currencyData = CurrencyData(
        "USD",
        "United States dollar",
        "$"
    )
    private val _languageData = LanguageData(
        "en",
        "eng",
        "English",
        "English"
    )
    private val _translationsData = TranslationsData(
        "Vereinigte Staaten von Amerika",
        "Estados Unidos",
        "États-Unis",
        "アメリカ合衆国",
        "Stati Uniti D'America",
        "Estados Unidos",
        "Estados Unidos",
        "Verenigde Staten",
        "Sjedinjene Američke Države",
        "ایالات متحده آمریکا"
    )
    private val _regionalBlocData = RegionalBlocData(
        "NAFTA",
        "North American Free Trade Agreement",
        listOf(),
        listOf(
            "Tratado de Libre Comercio de América del Norte",
            "Accord de Libre-échange Nord-Américain"
        )
    )
    private val _countryData = CountryData(
        "United States of America",
        listOf(".us"),
        "US",
        "USA",
        listOf("1"),
        "Washington, D.C.",
        listOf(
            "US",
            "USA",
            "United States of America"
        ),
        "Americas",
        "Northern America",
        323947000,
        listOf(
            38,
            -97
        ),
        "American",
        9629091,
        48.0f,
        listOf(
            "UTC-12:00",
            "UTC-11:00",
            "UTC-10:00",
            "UTC-09:00",
            "UTC-08:00",
            "UTC-07:00",
            "UTC-06:00",
            "UTC-05:00",
            "UTC-04:00",
            "UTC+10:00",
            "UTC+12:00"
        ),
        listOf(
            "CAN",
            "MEX"
        ),
        "United States",
        "840",
        listOf(_currencyData),
        listOf(_languageData),
        _translationsData,
        "https://restcountries.eu/data/usa.svg",
        listOf(_regionalBlocData),
        "USA"
    )

    private val _currency = Currency(
        "United States dollar",
        "$",
        "USD"
    )
    private val _language = Language(
        "English",
        "English",
        "eng"
    )
    private val _country = Country(
        "https://restcountries.eu/data/usa.svg",
        "United States of America",
        "United States",
        "USA",
        "Washington, D.C.",
        "American",
        listOf(_language),
        listOf(_currency),
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

    val countryData: CountryData get() = _countryData
    val currencyData: CurrencyData get() = _currencyData
    val languageData: LanguageData get() = _languageData

    val country: Country get() = _country
    val currency: Currency get() = _currency
    val language: Language get() = _language

    val countriesFromApi: Single<List<CountryData>> get() = Single.just(List(3) { _countryData })
    val countryFromApi: Maybe<CountryData> get() = Maybe.just(_countryData)
}
