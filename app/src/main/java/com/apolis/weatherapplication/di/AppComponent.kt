package com.apolis.weatherapplication.di

import com.apolis.weatherapplication.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(RetrofitClient::class,ViewModelFactoryModule::class,ViewModelModule::class))
interface AppComponent {

    fun inject(mainActivity: MainActivity)

}