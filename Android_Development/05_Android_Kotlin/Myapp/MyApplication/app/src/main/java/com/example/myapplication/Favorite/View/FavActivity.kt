package com.example.myapplication.favorite.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import com.example.myapplication.Favorite.View.
import com.example.myapplication.R
import com.example.myapplication.database.DB_Creator
import com.example.myapplication.database.Fav_Product_DB_DAO
import com.example.myapplication.database.ProductsLocalDataSourceImpl
import com.example.myapplication.favorite.viewmodel.FavoriteViewModel
import com.example.myapplication.favorite.viewmodel.FavoriteViewModelFactory
import com.example.myapplication.model.Product
import com.example.myapplication.model.ProductsRepositoryImpl
import com.example.myapplication.network.ProductsRemoteDataSourceImpl
import kotlinx.coroutines.launch

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

        val database = DB_Creator.getDatabase(this) // Get your Room database instance
        val dao: Fav_Product_DB_DAO = database.favProductDao() // Obtain the DAO

        localDataSource = ProductsLocalDataSourceImpl(dao) // Pass the DAO to your local data source
        remoteDataSource = ProductsRemoteDataSourceImpl() // Initialize your remote data source
        repository = ProductsRepositoryImpl(localDataSource, remoteDataSource) // Initialize repository



        // Initialize ViewModel
        val factory = FavoriteViewModelFactory(repository)
        favoriteViewModel = viewModels<FavoriteViewModel> { factory }.value

        // Observe favorite products
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
