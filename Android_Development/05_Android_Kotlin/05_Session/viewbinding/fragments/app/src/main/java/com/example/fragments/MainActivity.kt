package com.example.fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.fragments.databinding.ActivityMainBinding // Import the generated binding class

internal interface Communicator {
    fun updateProduct(name: String, price: String, imageUrl: String)
}

class MainActivity : AppCompatActivity(), Communicator {

    private lateinit var binding: ActivityMainBinding // Declare the binding variable
    private lateinit var fgr: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater) // Inflate the binding
        setContentView(binding.root) // Set the root view from the binding
    }

    override fun updateProduct(name: String, price: String, imageUrl: String) {
        val frag: Fragment2 = fgr.findFragmentById(R.id.fragmentContainerView5) as Fragment2
        frag.updateProductInfo(name, price, imageUrl)
    }
}
