package com.example.a03_session

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnStart: Button
    private lateinit var btnStop: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart = findViewById(R.id.btn_start)
        btnStop = findViewById(R.id.btn_stop)

        btnStart.setOnClickListener {
            val intent = Intent(this, MystartedService::class.java)
            startService(intent)
        }

        btnStop.setOnClickListener {
            val intent = Intent(this, MystartedService::class.java)
            stopService(intent)
        }
    }
}
