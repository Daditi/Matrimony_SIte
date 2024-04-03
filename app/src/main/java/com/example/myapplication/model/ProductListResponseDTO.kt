package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

data class ProductListResponseDTO(
    @field:SerializedName("products")
    val products: List<ProductDTO>? = null
)

data class ProductDTO(
    @field:SerializedName("name")
    val name: String? = null,
    @field:SerializedName("price")
    val price: Int? = null,
    @field:SerializedName("delivery_tag")
    val deliveryTag: String? = null,
    @field:SerializedName("img_url")
    val imageUrl: String? = null,
)
