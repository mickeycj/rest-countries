package com.mickeycj.domain

import io.reactivex.Single

import com.mickeycj.domain.models.Country

object Faker {

    fun getCountries(): Single<List<Country>> = Single.just(listOf(Country(), Country(), Country()))

    fun getCountry(): Single<Country> = Single.just(Country())
}
