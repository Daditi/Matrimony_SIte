package com.example.myapplication.network

import com.example.myapplication.model.ProductListResponseDTO
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("list")
    suspend fun getProducts(): Response<ProductListResponseDTO>
}
