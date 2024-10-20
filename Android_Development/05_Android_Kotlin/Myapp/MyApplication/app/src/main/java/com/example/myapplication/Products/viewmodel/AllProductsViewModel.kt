package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.Product
import com.example.myapplication.model.ProductsRepository
import com.example.myapplication.network.ApiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class AllProductsViewModel(private val repository: ProductsRepository) : ViewModel() {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    val _stateFlow = MutableStateFlow<ApiState>(ApiState.Loading())
    val stateFlow : StateFlow<ApiState> = _stateFlow


//    init {
//        fetchProductsFromNetwork()
//    }

    fun fetchProductsFromNetwork() {
        viewModelScope.launch {
            Log.i("TAG", "nahass gettins products: ")

            repository.getAllProducts()
                .catch {e->
                    _stateFlow.value=ApiState.Failure(e)
                }
                .collect{
                    _products.postValue(it)
                    _stateFlow.value=ApiState.Success(it)
                }
        }
    }

    fun addProductToFavorites(product: Product) {
        viewModelScope.launch {
            Log.i("TAG", "nahass addProductToFavorites: ")
            repository.addProductToFavorites(product)
        }
    }
}
