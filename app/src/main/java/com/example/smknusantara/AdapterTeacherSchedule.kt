package com.example.smknusantara

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_schedule_teacher.view.*

class AdapterTeacherSchedule(val context:Context, val list:List<ScheduleTeacherResponse>):
    RecyclerView.Adapter<AdapterTeacherSchedule.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterTeacherSchedule.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_schedule_teacher,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AdapterTeacherSchedule.ViewHolder, position: Int) {
        val data = list[position]
        holder.itemView.subject.text = data.subject!!.name.toString()
        holder.itemView.kelas.text = data.kelas!!.name.toString()
        holder.itemView.day.text = data.day.toString()
        holder.itemView.time.text = data.time.toString()
    }

    inner class ViewHolder(itemview: View):RecyclerView.ViewHolder(itemview)
}