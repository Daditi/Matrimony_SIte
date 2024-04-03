package com.example.myapplication.model

data class ProductListResponse(
    val products: List<Product>
)

data class Product(
    val name: String = "",
    val price: Float? = null,
    val deliveryTag: String = "",
    val imageUrl: String = "",
)