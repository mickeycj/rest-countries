package com.mickeycj.domain

import io.reactivex.Maybe
import io.reactivex.Single

import com.mickeycj.domain.models.Country

/**
 * Object for providing mock data.
 */
object MockData {

    private val _country = Country()

    val countries: Single<List<Country>> get() = Single.just(List(3) { _country })
    val countryDetails: Maybe<Country> get() = Maybe.just(_country)
}
