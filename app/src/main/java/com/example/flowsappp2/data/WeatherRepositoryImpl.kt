package com.example.flowsappp2.data

import com.example.flowsappp2.domain.City
import com.example.flowsappp2.domain.CurrentWeather
import com.example.flowsappp2.domain.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api : WeatherApi
) : WeatherRepository {
    override suspend fun searchCities(name: String): Result<List<City>> {
        return try {
            val response = api.searchCity(name)
            Result.success(response.results ?: emptyList())
        } catch (e: Exception){
            Result.failure(e)
        }
    }

    override suspend fun fetchWeather(): Result<CurrentWeather> {
        return fetchWeather(52.52, 13.41)
    }

    override suspend fun fetchWeather(
        lat: Double,
        lon: Double
    ): Result<CurrentWeather> {
        return try {
            val response = api.getWeatherData(lat, lon)
            Result.success(response.currentWeather)
        } catch (e: Exception){
            Result.failure(e)
        }
    }
}