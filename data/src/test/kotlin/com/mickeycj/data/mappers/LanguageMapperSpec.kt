package com.mickeycj.data.mappers

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

import org.assertj.core.api.Assertions.assertThat

import com.mickeycj.data.MockData

/**
 * Spek tests for Language mapper.
 */
class LanguageMapperSpec : Spek({

    describe("Language Mapper") {

        val languageMapper by memoized { LanguageMapper() }

        context("When mapping language's data to its corresponding model") {
            it("It should return the correct model mapping") {
                val language = languageMapper.toModel(MockData.languageData)

                assertThat(language).isEqualTo(MockData.language)
            }
        }
    }
})
