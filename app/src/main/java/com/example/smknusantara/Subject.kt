package com.example.smknusantara

import com.google.gson.annotations.SerializedName

data class Subject(

	@field:SerializedName("Assignment")
	val assignment: Int? = null,

	@field:SerializedName("HeaderSchedules")
	val headerSchedules: List<HeaderSchedulesItem?>? = null,

	@field:SerializedName("Description")
	val description: String? = null,

	@field:SerializedName("Final_Exam")
	val finalExam: Int? = null,

	@field:SerializedName("SubjectID")
	val subjectID: Int? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("Mid_Exam")
	val midExam: Int? = null,

	@field:SerializedName("Name")
	val name: String? = null
)