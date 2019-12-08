package com.example.smknusantara

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface Network {

    @GET("api/Users")
    fun getUsers():Call<List<UserResponse>>

    @GET("api/Students/{id}")
    fun getStudent(@Path("id") id : Int):Call<List<StudentResponse>>

    @GET("api/Teachers/{id}")
    fun getTeacher(@Path("id") id : Int):Call<List<TeacherResponse>>

    @GET("api/HeaderSchedules/{id}")
    fun getScheduleStudent(@Path("id") id : Int):Call<List<ScheduleStudentResponse>>

    @GET("api/HeaderSchedulesTeacher/{id}")
    fun getScheduleTeacher(@Path("id") id : Int):Call<List<ScheduleTeacherResponse>>


    companion object{
        fun create() : Network {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.1.13:45455/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit.create(Network::class.java)
        }
    }

}