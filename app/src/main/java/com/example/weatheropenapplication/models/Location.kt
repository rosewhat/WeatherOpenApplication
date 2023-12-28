package com.example.weatheropenapplication.models

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("Version")
    val version: Int,
    @SerializedName("Key")
    val key: Int,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Rank")
    val rank: String,
    @SerializedName("LocalizedName")
    val localizedName: String,
    @SerializedName("englishName")
    val englishName: String,
    @SerializedName("PrimaryPostalCode")
    val primaryPostalCode: String,
    @SerializedName("Region")
    val region: Name,
    @SerializedName("Country")
    val country: Name,
    @SerializedName("timeZone")
    val timeZone: String,
    @SerializedName("GeoPosition")
    val value: Position,
    @SerializedName("IsAlias")
    val isAlias: Boolean,

)

data class Position(
    @SerializedName("Latitude")
    val latitude: Double,
    @SerializedName("Longitude")
    val longitude: Double,
    @SerializedName("PrimaryPostalCode")
    val primaryPostalCode: String,
    @SerializedName("Elevation")
    val elevation: Elevation
)
data class Elevation(
    @SerializedName("Metric")
    val metric: Value,
    @SerializedName("Imperial")
    val value: Value,

)

data class Value(
    @SerializedName("Value")
    val value: Double,
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int,
)

data class Name (
    @SerializedName("ID")
    val id: String,
    @SerializedName("LocalizedName")
    val localizedName: String,
    @SerializedName("EnglishName")
    val englishName: String,
)

data class TimeZone(
    @SerializedName("Code")
    val code: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("GmtOffset")
    val gmtOffset: Double,
    @SerializedName("isDaylightSaving")
    val isDaylightSaving: Boolean,
    @SerializedName("NextOffsetChange")
    val nextOffsetChange: String?,
)