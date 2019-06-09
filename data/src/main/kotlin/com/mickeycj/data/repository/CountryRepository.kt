package com.mickeycj.data.repository

import io.reactivex.Maybe
import io.reactivex.Single

import com.mickeycj.domain.contracts.Mapper
import com.mickeycj.domain.models.Country

import com.mickeycj.data.RestCountriesApi
import com.mickeycj.data.models.CountryData

/**
 * Remote repository for Country data.
 */
class CountryRepository(
    private val restCountriesApi: RestCountriesApi,
    private val countryMapper: Mapper<CountryData, Country>
) : com.mickeycj.domain.contracts.CountryRepository {

    override fun getCountries(): Single<List<Country>> {
        return restCountriesApi.getCountries().map { it.map(countryMapper::toModel) }
    }

    override fun getCountry(code: String): Maybe<Country> {
        return restCountriesApi.getCountryByCode(code).map(countryMapper::toModel)
    }
}
