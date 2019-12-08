package com.example.smknusantara

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_schedule_teacher.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ScheduleTeacher : AppCompatActivity() {

    lateinit var adapter:AdapterTeacherSchedule
    val list:MutableList<ScheduleTeacherResponse> = mutableListOf()
    var teacherID:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_teacher)

        val linearLayout = LinearLayoutManager(this)
        adapter = AdapterTeacherSchedule(this,list)

        recycler.layoutManager = linearLayout
        recycler.adapter = adapter

        teacherID = Integer.parseInt(intent.getStringExtra("id"))

        fill(teacherID)

    }

    private fun fill(id:Int){
        Network.create().getScheduleTeacher(id).enqueue(object : Callback<List<ScheduleTeacherResponse>>{
            override fun onFailure(call: Call<List<ScheduleTeacherResponse>>, t: Throwable) {
                Toast.makeText(this@ScheduleTeacher,t.toString(),Toast.LENGTH_SHORT)
            }

            override fun onResponse(
                call: Call<List<ScheduleTeacherResponse>>,
                response: Response<List<ScheduleTeacherResponse>>
            ) {
                list.clear()
                list.addAll(response.body()!!)
                adapter.notifyDataSetChanged()
            }

        })
    }
}
