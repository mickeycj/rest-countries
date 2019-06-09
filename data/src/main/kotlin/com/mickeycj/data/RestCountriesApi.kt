package com.mickeycj.data

import io.reactivex.Maybe
import io.reactivex.Single

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

import com.mickeycj.data.models.CountryData

/**
 * Interface for fetching data from REST Countries API.
 */
interface RestCountriesApi {

    companion object {
        private const val BASE_URL = "https://restcountries.eu/rest/v2/"

        fun create(): RestCountriesApi = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(RestCountriesApi::class.java)
    }

    @GET("all")
    fun getCountries(): Single<List<CountryData>>

    @GET("alpha/{code}")
    fun getCountryByCode(@Path("code") code: String): Maybe<CountryData>
}
