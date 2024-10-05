package com.example.product_app_mvc.Lists.Viewer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.product_app_mvc.AllProducts.Viewer.Viewer.MealDetailsActivity;
import com.example.product_app_mvc.Lists.Presenter.ListsPresenter;
import com.example.product_app_mvc.Lists.Presenter.ListsPresenterImp;
import com.example.product_app_mvc.Lists.Viewer.CategoryAdapter;
import com.example.product_app_mvc.Lists.Viewer.ListsView;
import com.example.product_app_mvc.R;
import com.example.product_app_mvc.model.Category;

import java.util.List;

public class ListsActivity extends AppCompatActivity implements OnItemClickListener, ListsView {

    RecyclerView CategoryrecyclerView;

    ListsPresenter presenter;
    CategoryAdapter catadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);

        // Initialize RecyclerView
        CategoryrecyclerView = findViewById(R.id.recyclerViewCategory);
        CategoryrecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        CategoryrecyclerView.setLayoutManager(layoutManager);

        catadapter = new CategoryAdapter(this, this);
        CategoryrecyclerView.setAdapter(catadapter);

        presenter = new ListsPresenterImp();

    }

    @Override
    public void showData(List<Category> data) {
        catadapter.setList(data);
    }

    @Override
    public void showCategoryDetails(String category) {
        // Implement show category details logic here
    }

    @Override
    public void showCountryDetails(String country) {
        // Implement show country details logic here
    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void onItemClick(Category item) {
        // Create an Intent to start MealDetailsActivity
        Intent intent = new Intent(this, MealDetailsActivity.class);

        // Pass data (the meal ID) to the new activity
        intent.putExtra("meal_ID", item.getIdCategory());

        // Start the new activity
        startActivity(intent);

        Log.i("TAG", "onItemClick");
        Toast.makeText(this, "Clicked: " + item.getIdCategory(), Toast.LENGTH_SHORT).show();
    }
}
