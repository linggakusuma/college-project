package com.academy.stikompoltek.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.academy.stikompoltek.data.local.ListSchedule
import com.academy.stikompoltek.databinding.ListItemChildScheduleBinding

class ScheduleChildAdapter(private val listSchedules: List<ListSchedule>) :
    RecyclerView.Adapter<ScheduleChildAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            ListItemChildScheduleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listSchedule = listSchedules[position]
        holder.bind(listSchedule)
    }

    override fun getItemCount(): Int {
        return listSchedules.size
    }

    inner class ViewHolder(private val binding: ListItemChildScheduleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listSchedule: ListSchedule) {
            binding.apply {
                item = listSchedule
            }
        }
    }
}