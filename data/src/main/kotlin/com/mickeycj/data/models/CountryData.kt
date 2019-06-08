package com.mickeycj.data.models

import com.google.gson.annotations.SerializedName

class CountryData(
    @SerializedName("name")
    val name: String,
    @SerializedName("topLevelDomain")
    val topLevelDomains: List<String>,
    @SerializedName("alpha2Code")
    val alpha2Code: String,
    @SerializedName("alpha3Code")
    val alpha3Code: String,
    @SerializedName("callingCodes")
    val callingCodes: List<String>,
    @SerializedName("capital")
    val capital: String,
    @SerializedName("altSpellings")
    val altSpellings: List<String>,
    @SerializedName("region")
    val region: String,
    @SerializedName("subregion")
    val subRegion: String,
    @SerializedName("population")
    val population: Int,
    @SerializedName("latlng")
    val coordinates: List<Int>,
    @SerializedName("demonym")
    val domenym: String,
    @SerializedName("area")
    val area: Int,
    @SerializedName("gini")
    val giniIndex: Float,
    @SerializedName("timezones")
    val timezones: List<String>,
    @SerializedName("borders")
    val borders: List<String>,
    @SerializedName("nativeName")
    val nativeName: String,
    @SerializedName("numericCode")
    val numericCode: String,
    @SerializedName("currencies")
    val currencies: List<CurrencyData>,
    @SerializedName("languages")
    val languages: List<LanguageData>,
    @SerializedName("translations")
    val translations: TranslationsData,
    @SerializedName("flag")
    val flag: String,
    @SerializedName("regionalBlocs")
    val regionalBlocs: List<RegionalBlocData>,
    @SerializedName("cioc")
    val cioc: String
)
