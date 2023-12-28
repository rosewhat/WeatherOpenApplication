package com.example.weatheropenapplication

import android.app.Application
import com.example.weatheropenapplication.network.Api
import com.example.weatheropenapplication.network.HeaderInterceptor
import com.example.weatheropenapplication.repositories.WeatherRepo
import com.example.weatheropenapplication.repositories.WeatherRepoImpl
import okhttp3.OkHttpClient
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(module {
                single {
                    val client = OkHttpClient.Builder()
                        .addInterceptor(HeaderInterceptor())
                        .build()
                    Retrofit
                        .Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client)
                        .baseUrl("http://dataservice.accuweather.com")
                        .build()
                }
                single {
                    val retrofit: Retrofit = get()
                    retrofit.create(Api::class.java)
                }
                single {
                    val api: Api = get()
                    WeatherRepoImpl(api)
                } bind WeatherRepo::class
            })
        }
    }
}