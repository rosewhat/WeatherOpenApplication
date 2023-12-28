package com.example.weatheropenapplication.network

import com.example.weatheropenapplication.models.DailyForecasts
import com.example.weatheropenapplication.models.HourlyForecast
import com.example.weatheropenapplication.models.Location
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val APIKEY = "LbdxCABRYFDaJfmxL1Lo9Jc6i6hjqhff"

interface Api {
    @GET("location/v1/cities/search")
    suspend fun searchLocation(
        @Query("apiKey") apiKey: String = APIKEY,
        @Query("q") query: String
    ): Response<List<Location>>

    @GET("forecasts/v1/daily/5day/{location_key}")
    suspend fun getDailyForecasts(
        @Path("location_key") locationKey: String,
        @Query("apikey") apiKey: String = APIKEY,
        @Query("metric") metric: Boolean = true
    ): Response<DailyForecasts>

    @GET("forecasts/v1/hourly/12hour/{location_key}")
    suspend fun getHourlyForecasts(
        @Path("location_key") locationKey: String,
        @Query("apikey") apiKey: String = APIKEY,
        @Query("metric") metric: Boolean = true
    ) : Response<List<HourlyForecast>>
}