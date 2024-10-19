package com.example.myapplication.Network

import com.example.myapplication.model.ProductsResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import retrofit2.HttpException

// Sealed class to represent API states
sealed class ApiState<out T> {
    object Loading : ApiState<Nothing>()
    data class Success<T>(val data: T) : ApiState<T>()
    data class Error(val message: String) : ApiState<Nothing>()
}

class ProductsRemoteDataSourceImpl : ProductsRemoteDataSource {

    // Create an instance of ProductService using RetrofitHelper
    private val productService: ProductService by lazy {
        RetrofitHelper.getInstance().create(ProductService::class.java)
    }

    // Backing property for the StateFlow
    private val _productsStateFlow = MutableStateFlow<ApiState<ProductsResponse>>(ApiState.Loading)
    override val productsStateFlow: StateFlow<ApiState<ProductsResponse>> = _productsStateFlow

    // Trigger API call and emit states
    override suspend fun fetchProducts() {
        _productsStateFlow.value = ApiState.Loading
        try {
            val response = productService.getProducts()
            if (response.isSuccessful) {
                response.body()?.let {
                    _productsStateFlow.value = ApiState.Success(it)
                } ?: run {
                    _productsStateFlow.value = ApiState.Error("Empty response")
                }
            } else {
                _productsStateFlow.value = ApiState.Error("Error: ${response.code()}")
            }
        } catch (e: HttpException) {
            _productsStateFlow.value = ApiState.Error("Network error: ${e.message}")
        } catch (e: Exception) {
            _productsStateFlow.value = ApiState.Error("Unknown error: ${e.message}")
        }
    }
}
