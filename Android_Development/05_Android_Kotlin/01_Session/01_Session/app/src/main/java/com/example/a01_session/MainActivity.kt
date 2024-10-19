package com.example.a01_session

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //ref bt n -> fin view by id
    // set on click listner
    // logic
    lateinit var btn : Button
    lateinit var textView : TextView
    lateinit var editText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.btnchange)
        textView = findViewById(R.id.vtname)
        editText = findViewById(R.id.etname)

//        btn.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(p0: View?) {
//                val str : String = editText.text.toString()
//                textView.text = str
//            }
//        })

        btn.setOnClickListener {
            val str : String = editText.text.toString()
            textView.text = str
        }

    }
}