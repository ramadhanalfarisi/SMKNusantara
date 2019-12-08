package com.example.smknusantara

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_schedule_student.view.*

class AdapterStudentSchedule(val context: Context, val list:List<ScheduleStudentResponse>): RecyclerView.Adapter<AdapterStudentSchedule.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterStudentSchedule.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_schedule_student,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AdapterStudentSchedule.ViewHolder, position: Int) {
        val data = list[position]
        holder.itemView.subject.text = data.subject!!.name.toString()
        holder.itemView.day.text = data.day.toString()
        holder.itemView.time.text = data.time.toString()
    }

    inner class ViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView)
}