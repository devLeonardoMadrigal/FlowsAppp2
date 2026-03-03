package com.example.flowsappp2.di

import com.example.flowsappp2.data.WeatherApi
import com.example.flowsappp2.data.WeatherRepositoryImpl
import com.example.flowsappp2.domain.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideApi(): WeatherApi = Retrofit.Builder()
        .baseUrl("https://api.open-meteo.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WeatherApi::class.java)

    @Provides
    fun provideRepo(
        api: WeatherApi
    ): WeatherRepository = WeatherRepositoryImpl(api)
}