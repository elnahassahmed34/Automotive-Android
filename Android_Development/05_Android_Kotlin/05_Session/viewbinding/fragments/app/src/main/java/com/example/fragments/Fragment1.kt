package com.example.fragments

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
import androidx.work.*
import com.example.fragments.databinding.Fragment1Binding // Import the generated binding class
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Fragment1 : Fragment() {

    private lateinit var binding: Fragment1Binding // Declare the binding variable
    private lateinit var recyclerAdapter: ListAdapterDemo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater, container, false) // Inflate the binding
        return binding.root // Return the root view from the binding
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up the RecyclerView
        recyclerAdapter = if (resources.configuration.orientation == ORIENTATION_LANDSCAPE) {
            ListAdapterDemo { product ->
                val communicator: Communicator = requireActivity() as Communicator
                communicator.updateProduct(product.title, product.price.toString(), product.thumbnail)
            }
        } else {
            ListAdapterDemo { product ->
                val intent = Intent(requireContext(), MainActivity2::class.java).apply {
                    putExtra("name", product.title)
                    putExtra("price", product.price.toString())
                    putExtra("image", product.thumbnail)
                }
                startActivity(intent)
            }
        }

        binding.rvRecyclerview.apply { // Use the binding to access the RecyclerView
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(requireContext()).apply {
                orientation = RecyclerView.VERTICAL
            }
        }

        // Start the worker to fetch products
        startProductWorker()
    }

    private fun startProductWorker() {
        val workRequest = OneTimeWorkRequestBuilder<ProductWorker>().build()

        WorkManager.getInstance(requireContext()).enqueue(workRequest)

        // Observe the work status
        WorkManager.getInstance(requireContext()).getWorkInfoByIdLiveData(workRequest.id)
            .observe(viewLifecycleOwner) { workInfo ->
                if (workInfo != null && workInfo.state.isFinished) {
                    fetchProducts()
                }
            }
    }

    private fun fetchProducts() {
        // Make a synchronous API call to get products and update RecyclerView
        RetrofitClient.api.getProducts().enqueue(object : Callback<ProductsResponse> {
            override fun onResponse(call: Call<ProductsResponse>, response: Response<ProductsResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let { productResponse ->
                        recyclerAdapter.submitList(productResponse.products)
                    }
                } else {
                    Toast.makeText(requireContext(), "Error fetching products", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ProductsResponse>, t: Throwable) {
                Toast.makeText(requireContext(), "Network error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
