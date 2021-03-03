package com.apolis.weatherapplication.di

import com.apolis.weatherapplication.app.Const
import com.apolis.weatherapplication.data.network.MyApi
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitClient {
    private val baseUrl = Const.BASE_URL
    private val retrofitBuilder: Retrofit.Builder

    init {
        retrofitBuilder = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

    }

    @Provides
    @Singleton
    fun getWeatherService(): MyApi {
        val retrofit = retrofitBuilder.build()
        return retrofit.create(MyApi::class.java)
    }


}