package com.mickeycj.data.mappers

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

import org.assertj.core.api.Assertions.assertThat

import com.mickeycj.domain.models.Language

import com.mickeycj.data.MockData

/**
 * Spek tests for Language mapper.
 */
class LanguageMapperSpec : Spek({

    describe("Language Mapper") {

        val languageMapper by memoized { LanguageMapper() }

        context("Mapping language's data to its corresponding model") {

            val mockLanguageData = MockData.languageData
            val mockLanguage = MockData.language

            lateinit var result: Language

            beforeEach {
                result = languageMapper.toModel(mockLanguageData)
            }
            it("Should return the correct model mapping") {
                assertThat(result).isEqualTo(mockLanguage)
            }
        }
    }
})
