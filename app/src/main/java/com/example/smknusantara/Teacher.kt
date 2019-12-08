package com.example.smknusantara

import com.google.gson.annotations.SerializedName

data class Teacher(

	@field:SerializedName("DateOfBirth")
	val dateOfBirth: String? = null,

	@field:SerializedName("HeaderSchedules")
	val headerSchedules: List<HeaderSchedulesItem?>? = null,

	@field:SerializedName("Address")
	val address: String? = null,

	@field:SerializedName("UserID")
	val userID: Int? = null,

	@field:SerializedName("Photo")
	val photo: String? = null,

	@field:SerializedName("Gender")
	val gender: String? = null,

	@field:SerializedName("NoHp")
	val noHp: String? = null,

	@field:SerializedName("TeacherID")
	val teacherID: Int? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("Name")
	val name: String? = null
)