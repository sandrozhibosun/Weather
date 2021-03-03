package com.apolis.weatherapplication.data.model

data class WeatherResponse(
    var current: Current,
    var daily: ArrayList<Daily>,
    var lat: Double,
    var lon: Double,
    var minutely: List<Minutely>,
    var timezone: String,
    var timezone_offset: Int
)

data class Current(
    val clouds: Int,
    val dew_point: Double,
    var dt: Int,
    var feels_like: Double,
    var humidity: Int,
    var pressure: Int,
    var sunrise: Int,
    var sunset: Int,
    var temp: Double,
    val uvi: Double,
    val visibility: Int,
    val weather: List<Weather>,
    val wind_deg: Int,
    val wind_speed: Double
)

data class Daily(
    val clouds: Int,
    val dew_point: Double,
    val dt: Int,
    val feels_like: FeelsLike,
    val humidity: Int,
    val pop: Double,
    val pressure: Int,
    val sunrise: Int,
    val sunset: Int,
    var temp: Temp,
    val uvi: Double,
    val weather: List<WeatherX>,
    val wind_deg: Int,
    val wind_speed: Double
)

data class Minutely(
    val dt: Int,
    val precipitation: Int
)

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)

data class FeelsLike(
    var day: Double,
    val eve: Double,
    val morn: Double,
    val night: Double
)

data class Temp(
    var day: Double,
    val eve: Double,
    val max: Double,
    val min: Double,
    val morn: Double,
    val night: Double
)

data class WeatherX(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)