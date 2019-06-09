package com.mickeycj.data.models

import com.google.gson.annotations.SerializedName

/**
 * Object for Currency JSON data.
 */
class CurrencyData(
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String
)
