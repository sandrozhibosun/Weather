package com.apolis.weatherapplication.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apolis.weatherapplication.data.model.Daily
import com.apolis.weatherapplication.databinding.ItemDailyBinding

class WeatherAdapter(val mContext:Context):RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {
    var mList=ArrayList<Daily>()

    inner class ViewHolder(val binding:ItemDailyBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val mBindingAdapter = ItemDailyBinding.inflate(layoutInflater)
        return ViewHolder(mBindingAdapter)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var weather=mList[position]
        holder.binding.weather=weather
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setData(dailyList:ArrayList<Daily>){
        mList=dailyList
        notifyDataSetChanged()
    }

}