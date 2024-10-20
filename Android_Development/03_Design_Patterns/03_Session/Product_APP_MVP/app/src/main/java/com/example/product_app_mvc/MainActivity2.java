package com.example.product_app_mvc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.product_app_mvc.AllProducts.Viewer.Viewer.AllProductActivity;
import com.example.product_app_mvc.FavProducts.View.FavProductActivity;

public class MainActivity2 extends AppCompatActivity {

    Button btnShowAll;
    Button btnShowFavs;
    Button btnClose;
    ImageView myimg;
    int thumbnail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        btnShowAll = findViewById(R.id.btnShowAll);
        btnShowFavs = findViewById(R.id.btnShowFavs);
        btnClose = findViewById(R.id.btnClose);
        thumbnail=R.drawable.myimage;
        myimg = findViewById(R.id.imageView2);
        myimg.setImageResource(thumbnail);

        btnShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, AllProductActivity.class);
                startActivity(intent);
            }
        });

        btnShowFavs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, FavProductActivity.class);
                startActivity(intent);
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}