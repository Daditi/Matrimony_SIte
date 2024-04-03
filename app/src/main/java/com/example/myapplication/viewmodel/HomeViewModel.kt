package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.ProductRepository
import com.example.myapplication.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val listRepository: ProductRepository
) : ViewModel() {
    private val _productList = MutableStateFlow<List<Product>>(emptyList())
    val productList = _productList.asStateFlow()

    init {
        getProductList()
    }

    private fun getProductList() = viewModelScope.launch(Dispatchers.IO) {
        Log.d("productList", listRepository.getProducts().toString())
        _productList.emit(listRepository.getProducts())
    }
}