package com.example.myapplication.Products.View

//import ProductsRemoteDataSourceImpl
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Network.ProductService
import com.example.myapplication.Network.ProductsRemoteDataSourceImpl
import com.example.myapplication.R
import com.example.myapplication.View.AllProductAdapter
import com.example.myapplication.database.DB_Creator
import com.example.myapplication.database.Fav_Product_DB_DAO
import com.example.myapplication.database.ProductsLocalDataSourceImpl
import com.example.myapplication.model.ProductsRepositoryImpl
//import com.example.myapplication.network.ProductService
//import com.example.myapplication.network.ProductsRemoteDataSourceImpl
import com.example.myapplication.viewmodel.AllProductsViewModel
import com.example.myapplication.viewmodel.AllProductsViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AllProductActivity : AppCompatActivity() {

    private lateinit var localDataSource: ProductsLocalDataSourceImpl
    private lateinit var remoteDataSource: ProductsRemoteDataSourceImpl
    private lateinit var repository: ProductsRepositoryImpl
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

        // Initialize Retrofit and ProductService


//        val productService: ProductService = retrofit.create(ProductService::class.java)

        // Initialize data sources
        localDataSource = ProductsLocalDataSourceImpl(dao) // Pass the DAO to your local data source
        remoteDataSource = ProductsRemoteDataSourceImpl() // Initialize your remote data source with ProductService

        // Initialize repository
        repository = ProductsRepositoryImpl(localDataSource, remoteDataSource) // Initialize repository

        // Initialize RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewProducts)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize Adapter
        allProductAdapter = AllProductAdapter()
        recyclerView.adapter = allProductAdapter

        // Observe product list from ViewModel
        viewModel.products.observe(this, Observer { products ->
            allProductAdapter.setProducts(products)
        })

        // Set up favorite button click listener
        allProductAdapter.setOnFavoriteClickListener { product ->
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.addProductToFavorites(product)
            }
            Toast.makeText(this, "Added to Favorites", Toast.LENGTH_SHORT).show()
        }
    }
}
