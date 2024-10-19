package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.Product
import com.example.myapplication.model.ProductsRepository
import com.example.myapplication.model.ProductsResponse
import kotlinx.coroutines.launch

class AllProductsViewModel(private val repository: ProductsRepository) : ViewModel() {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    init {
        fetchProductsFromNetwork()
    }

    private fun fetchProductsFromNetwork() {
        viewModelScope.launch {
            try {
                // Fetch response from repository
                val response: ProductsResponse? = repository.getAllProducts()

                // Check if response is not null and contains products
                response?.let { productsResponse ->
                    _products.postValue(productsResponse.products) // Update LiveData with products
                } ?: run {
                    Log.e("AllProductsViewModel", "Response is null or empty")
                }
            } catch (e: Exception) {
                // Log any exceptions that occur during the network call
                Log.e("AllProductsViewModel", "Network call failed: ${e.message}", e)
            }
        }
    }

    fun addProductToFavorites(product: Product) {
        viewModelScope.launch {
            try {
                Log.i("TAG", "Adding product to favorites: $product")
                // Call repository to add the product to favorites
                repository.addProductToFavorites(product)
            } catch (e: Exception) {
                // Log any exceptions that occur while adding to favorites
                Log.e("AllProductsViewModel", "Failed to add product to favorites: ${e.message}", e)
            }
        }
    }
}
