package com.mickeycj.data.mappers

import com.mickeycj.domain.contracts.Mapper
import com.mickeycj.domain.models.Currency

import com.mickeycj.data.models.CurrencyData

class CurrencyMapper : Mapper<CurrencyData, Currency> {

    override fun toModel(from: CurrencyData): Currency = Currency(
        from.name,
        from.symbol,
        from.code
    )
}
