package com.mickeycj.domain

import io.reactivex.Maybe
import io.reactivex.Single

import com.mickeycj.domain.models.Country

/**
 * Object for providing mock data.
 */
object MockData {

    private val _countryDetails = Country()

    val countries: Single<List<Country>>
        get() {
            return Single.just(List(3) { _countryDetails })
        }
    val countryDetails: Maybe<Country>
        get() {
            return Maybe.just(_countryDetails)
        }
}
