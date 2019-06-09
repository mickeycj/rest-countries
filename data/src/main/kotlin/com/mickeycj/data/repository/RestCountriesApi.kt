package com.mickeycj.data.repository

import io.reactivex.Maybe
import io.reactivex.Single

import retrofit2.http.GET
import retrofit2.http.Path

import com.mickeycj.data.models.CountryData

/**
 * Interface for fetching data from REST Countries API.
 */
interface RestCountriesApi {

    companion object {
        const val BASE_URL = "https://restcountries.eu/rest/v2/"
    }

    @GET("all")
    fun getCountries(): Single<List<CountryData>>

    @GET("alpha/{code}")
    fun getCountryByCode(@Path("code") code: String): Maybe<CountryData>
}
