package com.mickeycj.domain.contracts

import io.reactivex.Single

import com.mickeycj.domain.models.Country

/**
 * Repository interface for accessing Country data.
 */
interface CountryRepository {

    fun getCountries(): Single<List<Country>>

    fun getCountry(code: String): Single<Country>
}
