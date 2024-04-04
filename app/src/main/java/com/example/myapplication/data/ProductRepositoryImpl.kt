package com.example.myapplication.data

import com.example.myapplication.domain.ProductRepository
import com.example.myapplication.mapper.mapToProductResult
import com.example.myapplication.model.Product
import com.example.myapplication.network.APIService
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val apiService: APIService
) : ProductRepository {
    override suspend fun getProducts(): List<Product> {
        return runCatching {
            apiService.getProducts().body()?.products.mapToProductResult()
        }.getOrDefault(emptyList())
    }
}
