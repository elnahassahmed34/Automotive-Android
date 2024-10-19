package com.example.fragments

data class ProductsResponse(val products: List<Product>)

data class Product(val id: Int, val title: String, val price: Double, val thumbnail: String)
