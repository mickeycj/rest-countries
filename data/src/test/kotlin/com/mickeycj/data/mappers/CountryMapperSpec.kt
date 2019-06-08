package com.mickeycj.data.mappers

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verifyAll

import org.assertj.core.api.Assertions.assertThat

import com.mickeycj.domain.contracts.Mapper
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

        context("When mapping country's data to its corresponding model") {
            it("It should return the correct model mapping") {
                every {
                    currencyMapper.toModel(MockData.currencyData)
                } returns MockData.currency
                every {
                    languageMapper.toModel(MockData.languageData)
                } returns MockData.language

                val country = countryMapper.toModel(MockData.countryData)

                verifyAll {
                    currencyMapper.toModel(MockData.currencyData)
                    languageMapper.toModel(MockData.languageData)
                }
                confirmVerified(currencyMapper, languageMapper)

                assertThat(country).isEqualTo(MockData.country)
            }
        }
    }
})
