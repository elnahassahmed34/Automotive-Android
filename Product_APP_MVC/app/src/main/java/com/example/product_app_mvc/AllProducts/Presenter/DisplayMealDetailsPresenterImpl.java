package com.example.product_app_mvc.AllProducts.Presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.product_app_mvc.AllProducts.Viewer.Viewer.MealDetailsView;
import com.example.product_app_mvc.Network.NetworkCallback;
import com.example.product_app_mvc.model.ProductsRepository;
import com.example.product_app_mvc.model.POJO_class;

import java.util.List;

public class DisplayMealDetailsPresenterImpl implements DisplayMealDetailsPresenter, NetworkCallback {
    private MealDetailsView _view;
    private ProductsRepository _repo;

    public DisplayMealDetailsPresenterImpl(MealDetailsView _view, ProductsRepository _repo) {
        this._view = _view;
        this._repo = _repo;
    }

    @Override
    public void getMealDetails() {
        this._repo.getAllProducts(this);
    }

    @Override
    public void onSuccessResult(List<POJO_class> myproducts) {
        _view.showMealDisplay(myproducts);
    }


    @Override
    public void addToFav(POJO_class myProduct) {
        _repo.insertProduct(myProduct);
        Log.i("TAG", "addToFav");
    }

    @Override
    public void onFailureResult(String ErrorMsg) {

    }
}
