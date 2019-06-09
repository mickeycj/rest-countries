package com.mickeycj.data.mappers

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verifyAll

import org.assertj.core.api.Assertions.assertThat

import com.mickeycj.domain.contracts.Mapper
import com.mickeycj.domain.models.Country
import com.mickeycj.domain.models.Currency
import com.mickeycj.domain.models.Language

import com.mickeycj.data.MockData
import com.mickeycj.data.models.CurrencyData
import com.mickeycj.data.models.LanguageData

/**
 * Spek tests for Country mapper.
 */
class CountryMapperSpec : Spek({

    describe("Country Mapper") {

        val currencyMapper by memoized { mockk<Mapper<CurrencyData, Currency>>() }
        val languageMapper by memoized { mockk<Mapper<LanguageData, Language>>() }
        val countryMapper by memoized { CountryMapper(currencyMapper, languageMapper) }

        context("Mapping country's data to its corresponding model") {

            val mockCountryData = MockData.countryData
            val mockCurrencyData = MockData.currencyData
            val mockLanguageData = MockData.languageData
            val mockCountry = MockData.country
            val mockCurrency = MockData.currency
            val mockLanguage = MockData.language

            lateinit var result: Country

            beforeEach {
                every {
                    currencyMapper.toModel(mockCurrencyData)
                } returns mockCurrency
                every {
                    languageMapper.toModel(mockLanguageData)
                } returns mockLanguage

                result = countryMapper.toModel(mockCountryData)
            }
            it("Should call its helper mappers") {
                verifyAll {
                    currencyMapper.toModel(mockCurrencyData)
                    languageMapper.toModel(mockLanguageData)
                }
                confirmVerified(currencyMapper, languageMapper)
            }
            it("Should return the correct model mapping") {
                assertThat(result).isEqualTo(mockCountry)
            }
        }
    }
})
