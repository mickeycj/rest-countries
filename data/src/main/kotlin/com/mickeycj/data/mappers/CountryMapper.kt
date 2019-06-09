package com.mickeycj.data.mappers

import com.mickeycj.domain.contracts.Mapper
import com.mickeycj.domain.models.Country
import com.mickeycj.domain.models.Currency
import com.mickeycj.domain.models.Language

import com.mickeycj.data.models.CountryData
import com.mickeycj.data.models.CurrencyData
import com.mickeycj.data.models.LanguageData

/**
 * Mapper for converting Country JSON data to its domain model.
 */
class CountryMapper(
    private val currencyMapper: Mapper<CurrencyData, Currency>,
    private val languageMapper: Mapper<LanguageData, Language>
) : Mapper<CountryData, Country> {

    override fun toModel(from: CountryData): Country = Country(
        from.flag,
        from.name,
        from.nativeName,
        from.alpha3Code,
        from.capital,
        from.demonym,
        from.languages.map(languageMapper::toModel),
        from.currencies.map(currencyMapper::toModel),
        from.borders.toList(),
        from.region,
        from.coordinates[0].toFloat(),
        from.coordinates[1].toFloat(),
        from.area.toFloat(),
        from.population,
        from.giniIndex
    )
}
