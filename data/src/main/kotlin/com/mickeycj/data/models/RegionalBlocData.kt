package com.mickeycj.data.models

import com.google.gson.annotations.SerializedName

/**
 * Object for Regional Bloc JSON data.
 */
class RegionalBlocData(
    @SerializedName("acronym")
    val acronym: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("otherAcronyms")
    val otherAcronyms: List<String>,
    @SerializedName("otherNames")
    val otherNames: List<String>
)
