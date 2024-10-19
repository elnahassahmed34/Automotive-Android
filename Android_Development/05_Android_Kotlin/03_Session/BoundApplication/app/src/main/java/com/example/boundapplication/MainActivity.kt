package com.example.boundapplication

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var myService:BoundService
    var isBound:Boolean=false
    lateinit var showdate:Button
    lateinit var datetxt:TextView

    private var myConnection:ServiceConnection=object :ServiceConnection{
        override fun onServiceConnected(p0: ComponentName?, service: IBinder?) {
            var binder:BoundService.MyLocalBinder=service as BoundService.MyLocalBinder
            myService=binder.getService()
            isBound=true
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            isBound=false
        }

    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        showdate=findViewById(R.id.btnshowdate)
        datetxt=findViewById(R.id.dateview)
        val intent=Intent(this,BoundService::class.java)
        bindService(intent,myConnection,Context.BIND_AUTO_CREATE)

        showdate.setOnClickListener {
            showDate(it)
        }

    }

    fun showDate(view:View){
        val currentTime:String=myService.getCurrentTime()
        datetxt.text=currentTime
    }
}