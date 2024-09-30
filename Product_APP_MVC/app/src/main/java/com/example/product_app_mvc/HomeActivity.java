package com.example.product_app_mvc;

import android.annotation.SuppressLint;
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

import com.example.product_app_mvc.AllProducts.Viewer.Viewer.MealDetailsActivity;
import com.example.product_app_mvc.FavProducts.View.FavProductActivity;

public class HomeActivity extends AppCompatActivity {

    Button btnShowAll;
    Button btnShowFavs;
    Button btnClose;
    Button btnSearch;
    ImageView myimg;
    int thumbnail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        btnShowAll = findViewById(R.id.btnShowAll);
        btnShowFavs = findViewById(R.id.btnShowFavs);
        btnClose = findViewById(R.id.btnClose);
        btnSearch = findViewById(R.id.btnSearch);

        thumbnail=R.drawable.myimage;
        myimg = findViewById(R.id.imageView2);
        myimg.setImageResource(thumbnail);

        btnShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MealDetailsActivity.class);
                startActivity(intent);
            }
        });

        btnShowFavs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, FavProductActivity.class);
                startActivity(intent);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, com.example.product_app_mvc.SearchActivity.class);
                startActivity(intent);
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}