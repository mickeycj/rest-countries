package com.mickeycj.data.mappers

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

import org.assertj.core.api.Assertions.assertThat

import com.mickeycj.domain.models.Currency

import com.mickeycj.data.MockData

/**
 * Spek tests for Currency mapper.
 */
class CurrencyMapperSpec : Spek({

    describe("Currency Mapper") {

        val currencyMapper by memoized { CurrencyMapper() }

        context("Mapping currency's data to its corresponding model") {

            val mockCurrencyData = MockData.currencyData
            val mockCurrency = MockData.currency

            lateinit var result: Currency

            beforeEach {
                result = currencyMapper.toModel(mockCurrencyData)
            }
            it("Should return the correct model mapping") {
                assertThat(result).isEqualTo(mockCurrency)
            }
        }
    }
})
