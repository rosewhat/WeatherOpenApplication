package com.example.weatheropenapplication.repositories

import com.example.weatheropenapplication.models.BaseModel
import com.example.weatheropenapplication.models.DailyForecast
import com.example.weatheropenapplication.models.DailyForecasts
import com.example.weatheropenapplication.models.HourlyForecast
import com.example.weatheropenapplication.models.Location
import com.example.weatheropenapplication.network.Api
import retrofit2.Response
import java.lang.Exception

class WeatherRepoImpl(private val api: Api):WeatherRepo {
    override suspend fun searchLocation(query: String): BaseModel<List<Location>> {
        return request {
            api.searchLocation(query = query)
        }
    }

    override suspend fun getDailyForecasts(locationKey: String): BaseModel<DailyForecasts> {
        return request {
            api.getDailyForecasts(locationKey = locationKey)
        }
    }

    override suspend fun getHourlyForecasts(locationKey: String): BaseModel<List<HourlyForecast>> {
        return request {
            api.getHourlyForecasts(locationKey = locationKey)
        }
    }
}
suspend fun<T> request(request: suspend ()->Response<T>):BaseModel<T>{
    try {
        request().also {
            return if (it.isSuccessful){
                BaseModel.Success(it.body()!!)
            }else{
                BaseModel.Error(it.errorBody()?.string().toString())
            }
        }
    }catch (e:Exception){
        return BaseModel.Error(e.message.toString())
    }
}