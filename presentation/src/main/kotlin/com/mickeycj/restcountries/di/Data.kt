package com.mickeycj.restcountries.di

import com.mickeycj.domain.contracts.Mapper
import com.mickeycj.domain.models.Country
import com.mickeycj.domain.models.Currency
import com.mickeycj.domain.models.Language
import com.mickeycj.domain.usecases.GetCountriesUseCase
import com.mickeycj.domain.usecases.GetCountryDetailsUseCase

import com.mickeycj.data.mappers.CountryMapper
import com.mickeycj.data.mappers.CurrencyMapper
import com.mickeycj.data.mappers.LanguageMapper
import com.mickeycj.data.models.CountryData
import com.mickeycj.data.models.CurrencyData
import com.mickeycj.data.models.LanguageData
import com.mickeycj.data.repository.CountryRepository

/**
 * Data dependencies provider.
 */
object Data {

    val module = org.koin.dsl.module {
        single<Mapper<CurrencyData, Currency>> { CurrencyMapper() }
        single<Mapper<LanguageData, Language>> { LanguageMapper() }
        single<Mapper<CountryData, Country>> { CountryMapper(get(), get()) }

        single<com.mickeycj.domain.contracts.CountryRepository> { CountryRepository(get(), get()) }

        single { GetCountriesUseCase(get()) }
        single { GetCountryDetailsUseCase(get()) }
    }
}
