package com.example.smknusantara

import com.google.gson.annotations.SerializedName

data class Class(

	@field:SerializedName("HeaderSchedules")
	val headerSchedules: List<HeaderSchedulesItem?>? = null,

	@field:SerializedName("ClassID")
	val classID: Int? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("Name")
	val name: String? = null
)