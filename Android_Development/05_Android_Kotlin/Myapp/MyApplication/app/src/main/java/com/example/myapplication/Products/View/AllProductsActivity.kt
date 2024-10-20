package com.example.myapplication.Products.View

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.View.AllProductAdapter
import com.example.myapplication.database.DB_Creator
import com.example.myapplication.model.Product
import com.example.myapplication.database.ProductsLocalDataSourceImpl
import com.example.myapplication.network.ProductsRemoteDataSourceImpl
import com.example.myapplication.model.ProductsRepositoryImpl
import com.example.myapplication.database.Fav_Product_DB_DAO // Import your Room database class
import com.example.myapplication.network.ApiState
//import com.example.myapplication.model.Fav_Product_DB_DAO // Import your DAO
import com.example.myapplication.viewmodel.AllProductsViewModel
import com.example.myapplication.viewmodel.AllProductsViewModelFactory
import kotlinx.coroutines.launch

class AllProductActivity : AppCompatActivity() {

    private lateinit var localDataSource: ProductsLocalDataSourceImpl
    private lateinit var remoteDataSource: ProductsRemoteDataSourceImpl
    private lateinit var repository: ProductsRepositoryImpl

    lateinit var imageViewStates: ImageView


    private val viewModel: AllProductsViewModel by viewModels {
        AllProductsViewModelFactory(repository)
    }

    private lateinit var allProductAdapter: AllProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        // Initialize Database and DAO
        val database = DB_Creator.getDatabase(this) // Get your Room database instance
        val dao: Fav_Product_DB_DAO = database.favProductDao() // Obtain the DAO

        // Initialize data sources
        localDataSource = ProductsLocalDataSourceImpl(dao) // Pass the DAO to your local data source
        remoteDataSource = ProductsRemoteDataSourceImpl() // Initialize your remote data source
        repository = ProductsRepositoryImpl(localDataSource, remoteDataSource) // Initialize repository

        // Initialize RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewProducts)
        imageViewStates = findViewById(R.id.imageViewStates)

        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize Adapter
        allProductAdapter = AllProductAdapter()
        recyclerView.adapter = allProductAdapter

        // Observe product list from ViewModel
//        viewModel.products.observe(this, Observer { products ->
//            allProductAdapter.setProducts(products)
//        })

        viewModel.fetchProductsFromNetwork()

        lifecycleScope.launch {
            viewModel.stateFlow.collect { state ->
                when (state) {
                    is ApiState.Loading -> {
                        imageViewStates.visibility = View.VISIBLE
                        imageViewStates.setImageDrawable(ContextCompat.getDrawable(this@AllProductActivity, R.drawable.downloading))
                        Log.i("TAG", "nahass loading ")
                    }

                    is ApiState.Success -> {
                        Log.i("TAG", "nahass succcess ")
                        imageViewStates.visibility = View.GONE
                        Log.i("TAG", "nahass succcess ")
                        allProductAdapter.setProducts(state.data)
                        Log.i("TAG", "nahass success ")
                    }

                    is ApiState.Failure -> {
                        imageViewStates.visibility = View.VISIBLE
                        imageViewStates.setImageDrawable(ContextCompat.getDrawable(this@AllProductActivity, R.drawable.no_internet))
                        Log.i("TAG", "nahass failure ")

                    }
                }
            }
        }


        // Set up favorite button click listener
        allProductAdapter.setOnFavoriteClickListener { product ->
            viewModel.addProductToFavorites(product)

            Toast.makeText(this, "Added to Favorites", Toast.LENGTH_SHORT).show()
        }
    }
}
