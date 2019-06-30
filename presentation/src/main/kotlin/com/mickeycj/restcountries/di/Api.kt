package com.mickeycj.restcountries.di

import com.mickeycj.data.RestCountriesApi

/**
 * API dependency provider.
 */
object Api {

    val module = org.koin.dsl.module {
        single { RestCountriesApi.create() }
    }
}
