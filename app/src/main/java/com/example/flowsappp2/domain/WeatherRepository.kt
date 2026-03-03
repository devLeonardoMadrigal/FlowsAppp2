package com.example.flowsappp2.domain

interface WeatherRepository {
    suspend fun searchCities(name: String): Result<List<City>>
    suspend fun fetchWeather(): Result<CurrentWeather>
    suspend fun fetchWeather(lat: Double, lon: Double) : Result<CurrentWeather>
}