package com.example.myapplication.network

import com.example.myapplication.model.Product

sealed class ApiState{
    class Success(val data:List<Product>) : ApiState()
    class Failure(val msg: Throwable): ApiState()
    class Loading():ApiState()
}