package com.example.myapplication.favorite.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.Product
import com.example.myapplication.model.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class FavoriteViewModel(private val repository: ProductsRepository) : ViewModel() {
    // LiveData to observe the list of favorite products
    val favoriteProducts: Flow<List<Product>> = repository.getFavoriteProducts()

    // Method to delete a product from favorites
    fun deleteProductFromFavorites(product: Product) {
        viewModelScope.launch {
            repository.removeProductFromFavorites(product)
        }
    }
}
