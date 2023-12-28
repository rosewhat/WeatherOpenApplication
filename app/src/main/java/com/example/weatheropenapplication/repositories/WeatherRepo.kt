package com.example.weatheropenapplication.repositories

import com.example.weatheropenapplication.models.BaseModel
import com.example.weatheropenapplication.models.DailyForecasts
import com.example.weatheropenapplication.models.HourlyForecast
import com.example.weatheropenapplication.models.Location

interface WeatherRepo {
    suspend fun searchLocation(query: String) : BaseModel<List<Location>>
    suspend fun getDailyForecasts(locationKey: String) : BaseModel<DailyForecasts>
    suspend fun getHourlyForecasts(locationKey: String) : BaseModel<List<HourlyForecast>>
}