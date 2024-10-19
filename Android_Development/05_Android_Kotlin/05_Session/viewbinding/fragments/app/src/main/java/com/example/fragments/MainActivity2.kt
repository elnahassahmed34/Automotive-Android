package com.example.fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.fragments.databinding.ActivityMain2Binding // Import your generated binding class

class MainActivity2 : AppCompatActivity() {

    // Declare the binding variable
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize the binding variable
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}
