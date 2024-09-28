package com.example.product_app_mvc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.product_app_mvc.AllProducts.Viewer.Viewer.MealDetailsActivity;
import com.example.product_app_mvc.AllProducts.Viewer.Viewer.MealDetailsView;
import com.example.product_app_mvc.DB.ProductsLocalDataSourceImpl;
import com.example.product_app_mvc.Network.ProductsRemoteDataSourceImpl;
import com.example.product_app_mvc.model.POJO_class;
import com.example.product_app_mvc.model.ProductsRepositoryImpl;

import java.util.List;

import mealsSearch.Presenter.DisplayMealDetailsPresenterImpl;
import mealsSearch.Viewer.AdapterOfSearchFragment;
import mealsSearch.Viewer.MealSearchView;
import mealsSearch.Viewer.OnItemClickListener;

public class SearchActivity extends AppCompatActivity implements OnItemClickListener, MealSearchView {

    RecyclerView myrecyclerView;
    TextView editSearchtxt;
    Button btnSearch;
    Spinner searchTypeSpinner;
    String selectedSearchType;

    DisplayMealDetailsPresenterImpl mySearchForMealsImpl;
    AdapterOfSearchFragment  myAdapterOfSearchFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search);

        editSearchtxt = findViewById(R.id.editSearchtxt);
        btnSearch = findViewById(R.id.btnSearch);
        searchTypeSpinner = findViewById(R.id.spinner_search_type);
        // Setup spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.search_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        searchTypeSpinner.setAdapter(adapter);

        // Listen for spinner selection changes
        searchTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                selectedSearchType = parentView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing
            }
        });

        // Initialize RecyclerView
        myrecyclerView = findViewById(R.id.recyclerViewSearch);
        myrecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        myrecyclerView.setLayoutManager(layoutManager);

        myAdapterOfSearchFragment = new AdapterOfSearchFragment(this, this);

        myrecyclerView.setAdapter(myAdapterOfSearchFragment);

        mySearchForMealsImpl = new DisplayMealDetailsPresenterImpl( this, ProductsRepositoryImpl.getInstance(ProductsRemoteDataSourceImpl.getInstance(this), ProductsLocalDataSourceImpl.getInstance(this)));

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Arrabiata

                performSearch();
                //mySearchForMealsImpl.getProductsbyCountry(editSearchtxt.getText().toString()); //Canadian
                //mySearchForMealsImpl.getProductsbyIngredient(editSearchtxt.getText().toString());
                //mySearchForMealsImpl.getProductsbyCategory(editSearchtxt.getText().toString()); //Seafood

            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.search), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    private void performSearch() {
        String query = editSearchtxt.getText().toString();
        switch (selectedSearchType) {
            case "Category":
                mySearchForMealsImpl.getProductsbyCategory(query);
                break;
            case "Country":
                mySearchForMealsImpl.getProductsbyCountry(query);
                break;
            case "Ingredient":
                mySearchForMealsImpl.getProductsbyIngredient(query);
                break;
            default:
                Toast.makeText(this, "Please select a search type", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    @Override
    public void showMealDisplay(List<POJO_class> l_list) {
        Log.i("TAG", l_list.toString());
        myAdapterOfSearchFragment.setList(l_list);
        Log.i("TAG", "zzzz");
        myAdapterOfSearchFragment.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(POJO_class item) {
        //====================
        // Create an Intent to start MealDetailActivity
        Intent intent = new Intent(this, MealDetailsActivity.class);

        // Pass data (the meal name) to the new activity
        intent.putExtra("meal_ID", item.getIdMeal());

        // Start the new activity
        startActivity(intent);
        //====================

        Log.i("TAG", "onItemClick");
        Toast.makeText(this, "Clicked: " + item.getIdMeal(), Toast.LENGTH_SHORT).show();
    }
}