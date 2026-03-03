package com.example.flowsappp2.domain

data class WeatherState(
    val data: CurrentWeather? = null,
    val isLoading: Boolean = false,
    val selectedCityName: String = "",
)
