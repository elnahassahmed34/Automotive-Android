package com.example.weatherapp.features.home.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.weatherapp.R
import com.example.weatherapp.databinding.DailyItemBinding
import com.example.weatherapp.model.forecast.Daily
import com.example.weatherapp.utils.Constants
import com.example.weatherapp.utils.getIconRes
import com.example.weatherapp.utils.toFahrenheit
import com.example.weatherapp.utils.toKelvin
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class DailyAdapter(private val list: MutableList<Daily>, val tempUnit:String) : Adapter<DailyAdapter.DailyVH>() {

    inner class DailyVH(private val binding: DailyItemBinding) : ViewHolder(binding.root) {
        fun bind(item: Daily) {
            binding.tvDay.text = unixTimeToReadableDate(item.dt.toLong())
            binding.ivWeather.setImageResource(getIconRes(item.weather[0].icon))
            binding.tvDes.text = item.weather[0].description
            binding.tvTemp.text= convertTempToString(item.temp.min, tempUnit ).plus(" / ")//item.temp.min.toInt().toString().plus("°/")
                .plus(convertTempToString(item.temp.max, tempUnit ))
        }

        private fun convertTempToString(temp:Double,tempUnit:String) :String{
            return when(tempUnit){
                Constants.TempUnits.CELSIUS-> temp.toInt().toString().plus(binding.root.context.getString(
                    R.string.c))
                Constants.TempUnits.FAHRENHEIT-> temp.toFahrenheit().toInt().toString().plus(binding.root.context.getString(
                    R.string.f))
                Constants.TempUnits.KELVIN-> temp.toKelvin().toInt().toString().plus(binding.root.context.getString(
                    R.string.k))
                else -> "0.0"
            }
        }

        private fun unixTimeToReadableDate(unixTime: Long): String {
            val dateFormat = SimpleDateFormat("EEEE", Locale.US)
            dateFormat.timeZone = TimeZone.getDefault() // Set your desired time zone
            val date = Date(unixTime * 1000)
            return dateFormat.format(date)
        }
    }


    fun updateList(list: List<Daily>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyVH {
        val binding = DailyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DailyVH(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: DailyVH, position: Int) = holder.bind(list[position])
}