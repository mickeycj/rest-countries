package com.mickeycj.data.mappers

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

import org.assertj.core.api.Assertions.assertThat

import com.mickeycj.data.MockData

/**
 * Spek tests for Currency mapper.
 */
class CurrencyMapperSpec : Spek({

    describe("Currency Mapper") {

        val currencyMapper by memoized { CurrencyMapper() }

        context("When mapping currency's data to its corresponding model") {
            it("It should return the correct model mapping") {
                val currency = currencyMapper.toModel(MockData.currencyData)

                assertThat(currency).isEqualTo(MockData.currency)
            }
        }
    }
})
