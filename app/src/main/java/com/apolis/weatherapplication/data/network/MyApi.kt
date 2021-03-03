package com.apolis.weatherapplication.data.network

import android.graphics.Bitmap
import com.apolis.weatherapplication.app.Const
import com.apolis.weatherapplication.data.model.WeatherResponse
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MyApi {

    @GET("onecall")
    fun getWeatherThisLoc(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("exclude") exclude: String,
        @Query("appid") key: String
    ): Single<WeatherResponse>

}