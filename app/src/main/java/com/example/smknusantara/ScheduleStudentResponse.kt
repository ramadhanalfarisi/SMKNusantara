package com.example.smknusantara

import com.google.gson.annotations.SerializedName

data class ScheduleStudentResponse(

	@field:SerializedName("Teacher")
	val teacher: Teacher? = null,

	@field:SerializedName("Class")
	val kelas: Class? = null,

	@field:SerializedName("ClassID")
	val classID: Int? = null,

	@field:SerializedName("Time")
	val time: String? = null,

	@field:SerializedName("ScheduleID")
	val scheduleID: Int? = null,

	@field:SerializedName("SubjectID")
	val subjectID: Int? = null,

	@field:SerializedName("TeacherID")
	val teacherID: Int? = null,

	@field:SerializedName("Day")
	val day: String? = null,

	@field:SerializedName("Subject")
	val subject: Subject? = null,

	@field:SerializedName("id")
	val id: String? = null
)