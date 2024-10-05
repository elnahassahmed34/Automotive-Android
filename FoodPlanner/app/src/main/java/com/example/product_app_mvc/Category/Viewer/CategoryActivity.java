package com.example.product_app_mvc.Category.Viewer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.product_app_mvc.Category.Presenter.CategoryPresnterImp;
import com.example.product_app_mvc.DB.ProductsLocalDataSourceImpl;
import com.example.product_app_mvc.Network.ProductsRemoteDataSourceImpl;
import com.example.product_app_mvc.R;
import com.example.product_app_mvc.mealsSearch.Presenter.DisplayMealDetailsPresenterImpl;
import com.example.product_app_mvc.mealsSearch.Viewer.AdapterOfSearchFragment;
import com.example.product_app_mvc.model.Category;
import com.example.product_app_mvc.model.ProductsRepositoryImpl;

import java.util.List;

public class CategoryActivity extends AppCompatActivity implements MealCategoryView , OnItemClickListenerCat{

    RecyclerView myrecyclerView;

    CategoryPresnterImp presenter;
    AdapterOfCategory myAdapterOfCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category);

        myrecyclerView = findViewById(R.id.categoryRV);
        myrecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        myrecyclerView.setLayoutManager(layoutManager);

        myAdapterOfCategory = new AdapterOfCategory(this, this);

        myrecyclerView.setAdapter(myAdapterOfCategory);

        presenter = new CategoryPresnterImp( this, ProductsRepositoryImpl.getInstance(ProductsRemoteDataSourceImpl.getInstance(this), ProductsLocalDataSourceImpl.getInstance(this)));

        presenter.getCategory();








        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });





    }

    @Override
    public void showMealDisplay(List<Category> l_list) {
        Log.i("TAG", l_list.toString());
        myAdapterOfCategory.setList(l_list);
        Log.i("TAG", "zzzz");
        myAdapterOfCategory.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(Category item) {
        Toast.makeText(this, "Clicked: " + item.getStrCategory(), Toast.LENGTH_SHORT).show();
        // Create an Intent to start MealDetailActivity
        Intent intent = new Intent(this, CategoryMeals.class);

        // Pass data (the meal name) to the new activity
        intent.putExtra("meal_ID", item.getStrCategory());

        // Start the new activity
        startActivity(intent);
        //====================
    }
}