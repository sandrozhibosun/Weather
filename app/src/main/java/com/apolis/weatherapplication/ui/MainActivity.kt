package com.apolis.weatherapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.apolis.weatherapplication.R
import com.apolis.weatherapplication.databinding.ActivityMainBinding
import com.apolis.weatherapplication.di.DaggerAppComponent
import com.apolis.weatherapplication.viewmodel.MainViewModel
import com.apolis.weatherapplication.viewmodel.MyViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewmodelFatory: MyViewModelFactory
    lateinit var weatherAdapter: WeatherAdapter

    private val viewmodel by lazy {
        ViewModelProviders.of(this, viewmodelFatory).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()
    }

    private fun init() {
        DaggerAppComponent.create().inject(this)
        weatherAdapter = WeatherAdapter(this)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = weatherAdapter


        onGetData()
    }

    private fun onGetData() {
        viewmodel.getWeatherFromRepo().observe(this, {
            binding.weather = it
            weatherAdapter.setData(it.daily)
        })

    }


}