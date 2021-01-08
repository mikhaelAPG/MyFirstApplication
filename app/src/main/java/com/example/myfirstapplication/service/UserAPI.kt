package com.example.myfirstapplication.service

import com.example.myfirstapplication.model.user.UserRequest
import com.example.myfirstapplication.model.user.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {
    @POST("api/users")
    fun createUser(@Body req: UserRequest) : Call<UserResponse>
}