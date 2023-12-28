package com.example.weatheropenapplication.screens

import android.net.wifi.rtt.CivicLocationKeys
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatheropenapplication.models.BaseModel
import com.example.weatheropenapplication.models.DailyForecasts
import com.example.weatheropenapplication.models.HourlyForecast
import com.example.weatheropenapplication.repositories.WeatherRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class WeatherViewModel:ViewModel(), KoinComponent {
    private val repo: WeatherRepo by inject()

    private val _hourlyForecast: MutableStateFlow<BaseModel<List<HourlyForecast>>> = MutableStateFlow(BaseModel.Loading)
    val hourlyForecast = _hourlyForecast.asStateFlow()

    private  val _dailyForecast: MutableStateFlow<BaseModel<DailyForecasts>> = MutableStateFlow(BaseModel.Loading)
    val dailyForecast = _dailyForecast.asStateFlow()

    fun getHourlyForecast(locationKeys: String) {
        viewModelScope.launch {
            repo.getHourlyForecasts(locationKeys).also {
                data ->
                _hourlyForecast.update { data }
            }
        }
    }
    fun getDailyForecast(locationKeys: String) {
        viewModelScope.launch {
            repo.getDailyForecasts(locationKeys).also {
                    data ->
                _dailyForecast.update { data }
            }
        }
    }
}