package com.mickeycj.data.mappers

import com.mickeycj.domain.contracts.Mapper
import com.mickeycj.domain.models.Country
import com.mickeycj.domain.models.Currency
import com.mickeycj.domain.models.Language

import com.mickeycj.data.models.CountryData
import com.mickeycj.data.models.CurrencyData
import com.mickeycj.data.models.LanguageData

class CountryMapper(
    private val currencyMapper: Mapper<CurrencyData, Currency>,
    private val languageMapper: Mapper<LanguageData, Language>
) : Mapper<CountryData, Country> {

    override fun toModel(from: CountryData): Country = TODO()
}