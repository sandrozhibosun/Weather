package com.apolis.weatherapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.apolis.weatherapplication.data.repository.WeatherRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(val repository: WeatherRepository): ViewModel() {



    fun getWeatherFromRepo()=repository.getWeatherFromApi()

    override fun onCleared() {
        super.onCleared()
        repository.onClear()
    }

}