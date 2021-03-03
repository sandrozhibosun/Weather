package com.apolis.weatherapplication.data.repository

import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apolis.weatherapplication.app.Const
import com.apolis.weatherapplication.data.model.WeatherResponse
import com.apolis.weatherapplication.data.network.MyApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WeatherRepository @Inject constructor(val myApi: MyApi) {
    private val disposables:CompositeDisposable by lazy {
       CompositeDisposable()
    }

    fun getWeatherFromApi():MutableLiveData<WeatherResponse>{

        val res=MutableLiveData<WeatherResponse>()
        //LOCATION 30.503700,-90.458290
        val observable= myApi.getWeatherThisLoc(lat =30.503700,lon = -90.458290,Const.EXCLUDE,Const.API_KEY)
        disposables.add(
            observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableSingleObserver<WeatherResponse>(){
                override fun onSuccess(t: WeatherResponse) {
                    Log.d("abc","success on get")
                    res.postValue(t)
                }

                override fun onError(e: Throwable) {
                  Log.d("abc","error on get")
                }
            })
        )

    return res
    }
    fun onClear(){
        disposables.dispose()
    }

}