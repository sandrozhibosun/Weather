package com.apolis.weatherapplication.app.Helper

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*

class Helper {
    companion object{
        @JvmStatic
        @BindingAdapter("toDate")
        fun toDate(textView: TextView, time:Int) {
            var sdf = SimpleDateFormat("MM/dd/yyyy")
            var date = Date(time.toLong() * 1000)
            textView.text = "Date " + sdf.format(date)
        }

        @JvmStatic
        @BindingAdapter("toTime")
        fun toTime(textView: TextView, time:Int) {
            var sdf = SimpleDateFormat("HH:mm")
            var date = Date(time.toLong() * 1000)
            textView.text = sdf.format(date)
        }

        fun convertDate(time:Int): String {
            var sdf = SimpleDateFormat("MM/dd/yyyy")
            var date = Date(time.toLong() * 1000)
            return sdf.format(date)
        }
    }
}