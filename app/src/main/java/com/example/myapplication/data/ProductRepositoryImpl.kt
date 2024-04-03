package com.example.myapplication.data

import com.example.myapplication.domain.ProductRepository
import com.example.myapplication.mapper.mapToProductResult
import com.example.myapplication.model.Product
import com.example.myapplication.model.ProductDTO
import com.example.myapplication.network.APIService
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val apiService: APIService
) : ProductRepository {
    override suspend fun getProducts(): List<Product> {
        //return apiService.getProducts().body()?.products.mapToProductResult()
        return listOf(
            ProductDTO(
                name = "Item 1",
                price = 100,
                deliveryTag = "Same Day Shipping",
                imageUrl = "https://placehold.co/128"
            ),
            ProductDTO(
                name = "Item 2",
                price = 10,
                deliveryTag = "",
                imageUrl = "https://placehold.co/128"
            ),
            ProductDTO(
                name = "Item 3",
                price = 106,
                deliveryTag = "Same Day Shipping",
                imageUrl = ""
            ),
            ProductDTO(
                name = "Item 4",
                price = 1000,
                deliveryTag = "2 Hour Delivery",
                imageUrl = "https://placehold.co/128"
            ),
            ProductDTO(
                name = "Item 5",
                price = 400,
                deliveryTag = "",
                imageUrl = "https://placehold.co/128"
            ),
            ProductDTO(
                name = "Item 6",
                price = 300,
                deliveryTag = "",
                imageUrl = "https://placehold.co/128"
            ),
            ProductDTO(
                name = "Item 7",
                price = 40,
                deliveryTag = "",
                imageUrl = "https://placehold.co/128"
            ),
            ProductDTO(name = "Item 8", price = 200, deliveryTag = "", imageUrl = ""),
            ProductDTO(
                name = "Item 9",
                price = 4,
                deliveryTag = "",
                imageUrl = "https://placehold.co/128"
            ),
            ProductDTO(
                name = "Item 10",
                price = 600,
                deliveryTag = "",
                imageUrl = "https://placehold.co/128"
            )
        ).mapToProductResult()
    }
}
