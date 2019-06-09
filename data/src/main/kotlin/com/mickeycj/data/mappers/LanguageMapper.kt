package com.mickeycj.data.mappers

import com.mickeycj.domain.contracts.Mapper
import com.mickeycj.domain.models.Language

import com.mickeycj.data.models.LanguageData

/**
 * Mapper for converting Language JSON data to its domain model.
 */
class LanguageMapper : Mapper<LanguageData, Language> {

    override fun toModel(from: LanguageData): Language = Language(
        from.name,
        from.nativeName,
        from.iso639_2
    )
}
