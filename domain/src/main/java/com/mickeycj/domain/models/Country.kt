package com.mickeycj.domain.models

/**
 * Represents Country model.
 */
data class Country(
    val flagUrl: String = "",
    val name: String = "",
    val code: String = "",
    val capital: String = "",
    val demonym: String = "",
    val languages: List<Language> = listOf(),
    val currencies: List<Currency> = listOf(),
    val borders: List<Border> = listOf(),
    val region: String = "",
    val latitude: Float = 0.0f,
    val longitude: Float = 0.0f,
    val area: Float = 0.0f,
    val population: Int = 0,
    val giniIndex: Float = 0.0f
)
