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
import com.example.product_app_mvc.Random.Viewer.Viewer.MealDetailsActivity;
import com.example.product_app_mvc.Random.Viewer.Viewer.MealDetailsView;
import com.example.product_app_mvc.model.POJO_class;
import com.example.product_app_mvc.model.ProductsRepositoryImpl;

import java.util.List;

public class CategoryMeals extends AppCompatActivity implements Mealdetailview , OnItemClickListnerCatMeals {

    RecyclerView myrecyclerView;

    CategoryPresnterImp presenter;
    CategoryMealsAdapter myCategoryMealsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category_meals);



        String code = getIntent().getStringExtra("meal_ID");

        myrecyclerView = findViewById(R.id.CategoryMeals);
        myrecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        myrecyclerView.setLayoutManager(layoutManager);

        myCategoryMealsAdapter = new CategoryMealsAdapter(this, this);

        myrecyclerView.setAdapter(myCategoryMealsAdapter);

        presenter = new CategoryPresnterImp( this, ProductsRepositoryImpl.getInstance(ProductsRemoteDataSourceImpl.getInstance(this), ProductsLocalDataSourceImpl.getInstance(this)));

        Toast.makeText(this, "Clicked: 78y8" + code, Toast.LENGTH_SHORT).show();


        presenter.getProductsbyCategorys(code);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onItemClick(POJO_class item) {
        //====================
        // Create an Intent to start MealDetailActivity
        Intent intent = new Intent(this, MealDetailsActivity.class);

        // Pass data (the meal name) to the new activity
        intent.putExtra("code", "xxx");
        intent.putExtra("meal_ID", item.getIdMeal());

        // Start the new activity
        startActivity(intent);
        //====================

        Log.i("TAG", "onItemClick");
        Toast.makeText(this, "Clicked: " + item.getIdMeal(), Toast.LENGTH_SHORT).show();

    }


    @Override
    public void DisplayMeal(List<POJO_class> l_list) {
        Log.i("TAG", "l_list.toString()");
        myCategoryMealsAdapter.setList(l_list);
        Log.i("TAG", "zzzz");
        Log.i("TAG", l_list.get(0).getStrMeal());


        myCategoryMealsAdapter.notifyDataSetChanged();

    }
}