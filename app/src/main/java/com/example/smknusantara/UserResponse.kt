package com.example.smknusantara

import com.google.gson.annotations.SerializedName

data class UserResponse(

	@field:SerializedName("Role")
	val role: String? = null,

	@field:SerializedName("Username")
	val username: String? = null,

	@field:SerializedName("UserID")
	val userID: Int? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("Password")
	val password: String? = null
)