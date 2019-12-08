package com.example.smknusantara

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayInputStream
import java.util.*

class HomeActivity : AppCompatActivity() {

    var ClassID : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val UserID = Integer.parseInt(intent.getStringExtra("id"))

        Network.create().getStudent(UserID).enqueue(object : Callback<List<StudentResponse>>{
            override fun onFailure(call: Call<List<StudentResponse>>, t: Throwable) {
                Toast.makeText(this@HomeActivity,t.toString(), Toast.LENGTH_SHORT)
            }

            @SuppressLint("NewApi")
            override fun onResponse(
                call: Call<List<StudentResponse>>,
                response: Response<List<StudentResponse>>
            ) {
                val encoder = Base64.getDecoder().decode(response.body()!![0].photo)
                val inputStream = ByteArrayInputStream(encoder)
                val bitmap = BitmapFactory.decodeStream(inputStream)
                ivPerson.setImageBitmap(bitmap)
                txtName.text = response.body()!![0].name.toString()
                ClassID = response.body()!![0].classID!!
            }

        })

        btnSchedule.setOnClickListener {
            schedule(ClassID)
        }

        btnLogout.setOnClickListener {
            logout()
        }
    }

    private fun logout(){
        this.startActivity(Intent(this,MainActivity::class.java))
        finish()
    }

    fun schedule(id : Int){
        val intent = Intent(this,ScheduleStudent::class.java)
        intent.putExtra("id",ClassID.toString())
        startActivity(intent)
    }
}
