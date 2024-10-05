package com.example.product_app_mvc.Category.Presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.product_app_mvc.Category.Viewer.Mealdetailview;
import com.example.product_app_mvc.Network.NetworkCallback;
import com.example.product_app_mvc.mealsSearch.Presenter.DisplayMealDetailsPresenter;
import com.example.product_app_mvc.Category.Viewer.MealCategoryView;
import com.example.product_app_mvc.model.Category;
import com.example.product_app_mvc.model.POJO_class;
import com.example.product_app_mvc.model.ProductsRepository;

import java.util.List;

public class CategoryPresnterImp implements CategoryPresnter, NetworkCallback {
    private MealCategoryView _view;
    private Mealdetailview _view2;
    private ProductsRepository _repo;

    public CategoryPresnterImp(MealCategoryView _view, ProductsRepository _repo) {
        this._view = _view;
        this._repo = _repo;
    }

    public CategoryPresnterImp(Mealdetailview _view, ProductsRepository _repo) {
        this._view2 = _view;
        this._repo = _repo;
    }

    @Override
    public void onSuccessResult(List<POJO_class> myproducts) {
        Log.i("TAG",  "Nhaa64654754547546");

        _view2.DisplayMeal(myproducts);
        //Toast.makeText(this, "Clicked: " + myproducts.get(0).getStrArea(), Toast.LENGTH_SHORT).show();

        //Log.i("TAG",  myproducts.get(0).getStrArea());

    }

    @Override
    public void onFailureResult(String ErrorMsg) {
        Log.i("TAG", "qqqq");
    }

    @Override
    public void onSuccessResultcat(List<Category> Categries) {
        _view.showMealDisplay(Categries);

    }

    @Override
    public void onFailureResultcat(String ErrorMsg) {

    }


    @Override
    public void getCategory() {
        _repo.fetchCategory(this);
    }

    @Override
    public void getProductsbyCategorys(String l_category) {
        _repo.searchMealbyCategory(this,l_category);
    }
}
