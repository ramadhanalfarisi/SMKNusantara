package com.example.smknusantara

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home_teacher.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayInputStream
import java.util.*

class HomeTeacherActivity : AppCompatActivity() {

    var TeacherID:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_teacher)

        val UserID = Integer.parseInt(intent.getStringExtra("id"))

        Network.create().getTeacher(UserID).enqueue(object : Callback<List<TeacherResponse>> {
            override fun onFailure(call: Call<List<TeacherResponse>>, t: Throwable) {
                Toast.makeText(this@HomeTeacherActivity,t.toString(), Toast.LENGTH_SHORT)
            }

            @SuppressLint("NewApi")
            override fun onResponse(
                call: Call<List<TeacherResponse>>,
                response: Response<List<TeacherResponse>>
            ) {
                val encoder = Base64.getDecoder().decode(response.body()!![0].photo)
                val inputStream = ByteArrayInputStream(encoder)
                val bitmap = BitmapFactory.decodeStream(inputStream)
                ivPerson.setImageBitmap(bitmap)
                txtName.text = response.body()!![0].name.toString()
                TeacherID = response.body()!![0].teacherID!!
            }

        })

        btnSchedule.setOnClickListener {
            val intent = Intent(this,ScheduleTeacher::class.java)
            intent.putExtra("id",TeacherID.toString())
            startActivity(intent)
        }

        btnLogout.setOnClickListener {
            logout()
        }
    }

    private fun logout(){
        this.startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}
