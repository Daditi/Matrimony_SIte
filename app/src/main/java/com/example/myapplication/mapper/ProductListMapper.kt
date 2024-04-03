package com.example.myapplication.mapper

import com.example.myapplication.model.Product
import com.example.myapplication.model.ProductDTO

fun List<ProductDTO>?.mapToProductResult(): List<Product> = this?.map {
    Product(
        it.name.orEmpty(),
        it.price?.toFloat(),
        it.deliveryTag.orEmpty(),
        it.imageUrl.orEmpty()
    )
} ?: emptyList()