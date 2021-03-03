package com.apolis.weatherapplication.di

import androidx.lifecycle.ViewModelProvider
import com.apolis.weatherapplication.viewmodel.MyViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: MyViewModelFactory): ViewModelProvider.Factory
}