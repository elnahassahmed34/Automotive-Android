package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
//import com.example.myapplication.Favorite.View.FavActivity
import com.example.myapplication.Products.View.AllProductActivity
import com.example.myapplication.favorite.view.FavActivity

//import com.example.myapplication.Products.View



class MainActivity : AppCompatActivity() {

    private lateinit var btnShowAll: Button
    private lateinit var btnShowFavs: Button
    private lateinit var btnClose: Button
    private lateinit var myimg: ImageView
    private var thumbnail: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnShowAll = findViewById(R.id.btnShowAll)
        btnShowFavs = findViewById(R.id.btnShowFavs)
        btnClose = findViewById(R.id.btnClose)
        thumbnail = R.drawable.myimage
        myimg = findViewById(R.id.imageView2)
        myimg.setImageResource(thumbnail)

        btnShowAll.setOnClickListener {
            val intent = Intent(this@MainActivity, AllProductActivity::class.java)
            startActivity(intent)
        }

        btnShowFavs.setOnClickListener {
            val intent = Intent(this@MainActivity, FavActivity::class.java)
            startActivity(intent)
        }

        btnClose.setOnClickListener { finish() }
    }
}
