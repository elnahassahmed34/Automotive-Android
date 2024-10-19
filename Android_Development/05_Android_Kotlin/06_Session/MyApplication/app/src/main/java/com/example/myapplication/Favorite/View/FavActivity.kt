package com.example.myapplication.favorite.view

//import ProductsRemoteDataSourceImpl
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Network.ProductService
import com.example.myapplication.Network.ProductsRemoteDataSourceImpl
import com.example.myapplication.R
import com.example.myapplication.database.DB_Creator
import com.example.myapplication.database.Fav_Product_DB_DAO
import com.example.myapplication.database.ProductsLocalDataSourceImpl
import com.example.myapplication.favorite.viewmodel.FavoriteViewModel
import com.example.myapplication.favorite.viewmodel.FavoriteViewModelFactory
import com.example.myapplication.model.Product
import com.example.myapplication.model.ProductsRepositoryImpl
//import com.example.myapplication.network.ProductsRemoteDataSourceImpl
//import com.example.myapplication.network.ProductService
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FavActivity : AppCompatActivity() {

    private lateinit var favoriteViewModel: FavoriteViewModel
    private lateinit var adapter: FavAdapter
    private lateinit var recyclerView: RecyclerView

    private lateinit var localDataSource: ProductsLocalDataSourceImpl
    private lateinit var remoteDataSource: ProductsRemoteDataSourceImpl
    private lateinit var repository: ProductsRepositoryImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fav)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.fav_myRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = FavAdapter { product -> deleteProduct(product) } // Passing delete method
        recyclerView.adapter = adapter

        // Initialize the database and DAO
        val database = DB_Creator.getDatabase(this)
        val dao: Fav_Product_DB_DAO = database.favProductDao()

        // Initialize ProductService using Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.example.com/") // Replace with your base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val productService: ProductService = retrofit.create(ProductService::class.java)

        // Initialize remote and local data sources
        localDataSource = ProductsLocalDataSourceImpl(dao)
        remoteDataSource = ProductsRemoteDataSourceImpl()

        // Initialize repository
        repository = ProductsRepositoryImpl(localDataSource, remoteDataSource)

        // Initialize ViewModel with Factory
        val factory = FavoriteViewModelFactory(repository)
        favoriteViewModel = viewModels<FavoriteViewModel> { factory }.value

        // Observe favorite products using Flow and lifecycleScope
        lifecycleScope.launch {
            favoriteViewModel.favoriteProducts.collect { products ->
                adapter.submitList(products) // Update adapter with the collected products
            }
        }
    }

    private fun deleteProduct(product: Product) {
        favoriteViewModel.deleteProductFromFavorites(product)
    }
}
