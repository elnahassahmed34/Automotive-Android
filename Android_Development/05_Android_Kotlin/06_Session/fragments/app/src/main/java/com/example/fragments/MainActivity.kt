package com.example.fragments

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.lifecycleScope
import com.example.fragments.database.AppDatabase
import com.example.fragments.database.ProductDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal interface Communicator {
    fun updateProduct(name: String, price: String, imageUrl: String)
}

class MainActivity : AppCompatActivity(), Communicator {

    var fgr: FragmentManager = supportFragmentManager

    // Declare productDao
    private lateinit var productDao: ProductDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize Room database and DAO
        val db = AppDatabase.getDatabase(this)
        productDao = db.productDao()

        // Set up delete button
        val btnDelete: Button = findViewById(R.id.btn_delete)
        btnDelete.setOnClickListener {
            deleteAllProducts()
        }
    }

    private fun deleteAllProducts() {
        // Use lifecycleScope to launch a coroutine to delete the products
        lifecycleScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    productDao.deleteAll()  // Call to delete all products from the database
                }
                Log.i("MainActivity", "All products deleted successfully")
            } catch (e: Exception) {
                Log.e("MainActivity", "Error deleting products: ${e.message}")
            }
        }
    }

    override fun updateProduct(name: String, price: String, imageUrl: String) {
        // Handle product update in Fragment2
        val frag: Fragment2 = fgr.findFragmentById(R.id.fragmentContainerView5) as Fragment2
        frag.updateProductInfo(name, price, imageUrl)
    }
}
