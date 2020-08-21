package com.academy.stikompoltek.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.academy.stikompoltek.data.local.Schedule
import com.academy.stikompoltek.databinding.ListItemScheduleBinding
import com.smarteist.autoimageslider.SliderViewAdapter

class ScheduleAdapter(private val schedule: List<Schedule>) :
    SliderViewAdapter<ScheduleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        return ViewHolder(
            ListItemScheduleBinding.inflate(
                LayoutInflater.from(parent?.context),
                parent,
                false
            )
        )
    }

    override fun getCount(): Int {
        return schedule.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val schedule = schedule[position]
        holder.apply {
            bind(schedule)
            val childLayoutManager =
                LinearLayoutManager(holder.recyclerView.context, RecyclerView.VERTICAL, false)
            recyclerView.apply {
                layoutManager = childLayoutManager
                adapter = ScheduleChildAdapter(schedule.listSchedule ?: emptyList())
            }
        }
    }

    class ViewHolder(private val binding: ListItemScheduleBinding) :
        SliderViewAdapter.ViewHolder(binding.root) {
        fun bind(schedule: Schedule) {
            binding.apply {
                item = schedule
                if (schedule.listSchedule.isNullOrEmpty()) todayFree.visibility = View.VISIBLE
                else todayFree.visibility = View.GONE
            }
        }

        val recyclerView = binding.recyclerViewChildSchedule
    }

}