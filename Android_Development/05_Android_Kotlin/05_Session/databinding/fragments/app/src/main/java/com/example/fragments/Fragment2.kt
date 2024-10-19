package com.example.fragments

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.fragments.databinding.Fragment2Binding

class Fragment2 : Fragment() {

    private lateinit var binding: Fragment2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout with data binding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_2, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Handle the intent for portrait mode
        if (resources.configuration.orientation != ORIENTATION_LANDSCAPE) {
            val intent = this.activity?.intent
            if (intent != null) {
                // Set the product data from intent
                val name = intent.getStringExtra("name")
                val price = intent.getStringExtra("price")
                val imageUrl = intent.getStringExtra("image")

                if (name != null && price != null && imageUrl != null) {
                    val product = Product(0, name, price.toDouble(), imageUrl)
                    binding.product = product
                }
            }
        }
    }

    // Update the product information programmatically
    fun updateProductInfo(name: String, price: String, imageUrl: String) {
        val product = Product(0, name, price.toDouble(), imageUrl)
        binding.product = product
    }
}
