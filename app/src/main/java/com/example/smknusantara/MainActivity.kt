package com.example.smknusantara

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val list:MutableList<UserResponse> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Network.create().getUsers().enqueue(object : Callback<List<UserResponse>>{
            override fun onFailure(call: Call<List<UserResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.toString(),Toast.LENGTH_SHORT)
            }

            override fun onResponse(
                call: Call<List<UserResponse>>,
                response: Response<List<UserResponse>>
            ) {
                list.clear()
                list.addAll(response.body()!!)
            }

        })

        btnlogin.setOnClickListener {
            login()
        }

    }

    private fun login(){
        for (i in list){
            if (i.username.toString() == username.text.toString() && i.password.toString() == password.text.toString() && i.role.toString() == "Student"){
                val intent = Intent(this,HomeActivity::class.java)
                intent.putExtra("id",i.userID.toString())
                startActivity(intent)
                finish()
                Toast.makeText(this@MainActivity,"Berhasil Login",Toast.LENGTH_SHORT)
            }else if (i.username.toString() == username.text.toString() && i.password.toString() == password.text.toString() && i.role.toString() == "Teacher"){
                val intent = Intent(this,HomeTeacherActivity::class.java)
                intent.putExtra("id",i.userID.toString())
                startActivity(intent)
                finish()
                Toast.makeText(this@MainActivity,"Berhasil Login",Toast.LENGTH_SHORT)
            }else{
                Toast.makeText(this@MainActivity,"Akun Salah",Toast.LENGTH_SHORT)
            }
        }
    }
}
