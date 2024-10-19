package com.example.fragments

import android.content.Intent
import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class Fragment2 : Fragment() {

    lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_2, container, false)

        // Initialize textView here
        textView = view.findViewById(R.id.tv_fragmenttwo)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // If landscape, no need to get intent, as you are likely using communication between fragments
        if (resources.configuration.orientation == ORIENTATION_LANDSCAPE) {
            // No intent handling needed here for landscape
        } else {
            // Handle the intent for portrait mode
            val intent = this.activity?.intent
            if (intent != null) {
                textView.text = intent.getStringExtra("name")
            }
        }
    }

    // This function will now always have the textView initialized
    fun setTextView(str: String) {
        Log.i("TAG", "setTextView: $str 22")
        textView.text = str
    }
}
