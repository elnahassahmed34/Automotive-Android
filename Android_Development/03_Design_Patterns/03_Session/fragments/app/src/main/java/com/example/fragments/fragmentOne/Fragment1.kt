package com.example.fragments.fragmentOne

import android.content.Intent
import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.lifecycleScope
import com.example.fragments.Communicator
import com.example.fragments.MainActivity2
import com.example.fragments.R
import com.example.fragments.database.AppDatabase
import com.example.fragments.database.ProductDao
import com.example.fragments.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Fragment1 : Fragment() {

    private lateinit var recyclerAdapter: ListAdapterDemo
    private lateinit var recyclerView: RecyclerView

    private lateinit var productDao: ProductDao



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_1, container, false)
        recyclerView = view.findViewById(R.id.rv_recyclerview)

        val db = AppDatabase.getDatabase(requireContext())
        productDao = db.productDao()


        // Set up the RecyclerView based on orientation
        if (resources.configuration.orientation == ORIENTATION_LANDSCAPE) {
            recyclerAdapter = ListAdapterDemo { product ->
                val communicator: Communicator = this@Fragment1.activity as Communicator
                communicator.updateProduct(product.title, product.price.toString(), product.thumbnail)
            }
        } else {
            recyclerAdapter = ListAdapterDemo { product ->
                val intent = Intent(requireContext(), MainActivity2::class.java).apply {
                    putExtra("name", product.title)
                    putExtra("price", product.price.toString())
                    putExtra("image", product.thumbnail)
                }
                startActivity(intent)
            }
        }

        recyclerView.apply {
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(requireContext()).apply {
                orientation = RecyclerView.VERTICAL
            }
        }

        // Fetch products using coroutines
        fetchProducts()

        return view
    }

    private fun fetchProducts() {
        // Use lifecycleScope to launch a coroutine
        lifecycleScope.launch {
            try {
                // Fetch data from the API using coroutines
                val response = RetrofitClient.service.getProducts()

                if (response.products.isNotEmpty()) {
                    // Data is fetched successfully, insert into the Room database
                    withContext(Dispatchers.IO) {
                        // Insert all fetched products into the database
                        productDao.insertAll(response.products)
                    }

                    // Switch to the main thread to update the UI with the new data
                    withContext(Dispatchers.Main) {
                        recyclerAdapter.submitList(response.products)
                    }
                } else {
                    // Handle the case where the response is empty
                    withContext(Dispatchers.Main) {
                        Toast.makeText(requireContext(), "No products found", Toast.LENGTH_SHORT).show()
                    }
                }

            } catch (e: Exception) {
                // If there's an error (e.g., network issue), fetch data from the Room database
                withContext(Dispatchers.IO) {
                    val storedProducts = productDao.getAllProducts() // Fetch stored products from Room
                    withContext(Dispatchers.Main) {
                        if (storedProducts.isNotEmpty()) {
                            recyclerAdapter.submitList(storedProducts)
                        } else {
                            Toast.makeText(requireContext(), "No stored products available", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }

}
