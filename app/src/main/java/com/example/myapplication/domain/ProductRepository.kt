package com.example.myapplication.domain

import com.example.myapplication.model.Product

interface ProductRepository {
    suspend fun getProducts(): List<Product>
}