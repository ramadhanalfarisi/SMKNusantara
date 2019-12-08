package com.example.smknusantara

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_schedule_student.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ScheduleStudent : AppCompatActivity() {

    lateinit var adapter: AdapterStudentSchedule
    val list:MutableList<ScheduleStudentResponse> = mutableListOf()
    var id:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_student)
        val linearLayout = LinearLayoutManager(this)
        adapter = AdapterStudentSchedule(this,list)

        id = Integer.parseInt(intent.getStringExtra("id"))

        recycler.layoutManager = linearLayout
        recycler.adapter = adapter

        fill()

    }

    private fun fill(){
        Network.create().getScheduleStudent(id).enqueue(object : Callback<List<ScheduleStudentResponse>>{
            override fun onFailure(call: Call<List<ScheduleStudentResponse>>, t: Throwable) {
                Toast.makeText(this@ScheduleStudent,t.toString(), Toast.LENGTH_SHORT)
            }

            override fun onResponse(
                call: Call<List<ScheduleStudentResponse>>,
                response: Response<List<ScheduleStudentResponse>>
            ) {

                list.clear()
                list.addAll(response.body()!!)
                adapter.notifyDataSetChanged()
            }

        })
    }




}
