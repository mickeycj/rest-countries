package com.mickeycj.data.mappers

import com.mickeycj.domain.contracts.Mapper
import com.mickeycj.domain.models.Currency

import com.mickeycj.data.models.CurrencyData

/**
 * Mapper for converting Currency JSON data to its domain model.
 */
class CurrencyMapper : Mapper<CurrencyData, Currency> {

    override fun toModel(from: CurrencyData): Currency = Currency(
        from.name,
        from.symbol,
        from.code
    )
}
