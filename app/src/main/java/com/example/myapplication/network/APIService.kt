package com.example.myapplication.network

import com.example.myapplication.model.UserResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("api/")
    suspend fun getProducts(@Query("results") results: Int): Response<UserResponseDTO>
}
