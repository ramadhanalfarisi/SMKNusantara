package com.example.smknusantara

import com.google.gson.annotations.SerializedName

data class StudentResponse(

	@field:SerializedName("DateOfBirth")
	val dateOfBirth: String? = null,

	@field:SerializedName("Address")
	val address: String? = null,

	@field:SerializedName("UserID")
	val userID: Int? = null,

	@field:SerializedName("ClassID")
	val classID: Int? = null,

	@field:SerializedName("Photo")
	val photo: String? = null,

	@field:SerializedName("Gender")
	val gender: String? = null,

	@field:SerializedName("NoHp")
	val noHp: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("StudentID")
	val studentID: Int? = null,

	@field:SerializedName("Name")
	val name: String? = null
)