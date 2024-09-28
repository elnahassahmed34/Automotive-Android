package mealsSearch.Presenter;

import android.util.Log;

import com.example.product_app_mvc.AllProducts.Viewer.Viewer.MealDetailsView;
import com.example.product_app_mvc.Network.NetworkCallback;
import com.example.product_app_mvc.model.POJO_class;
import com.example.product_app_mvc.model.ProductsRepository;

import java.util.List;

import mealsSearch.Viewer.MealSearchView;

public class DisplayMealDetailsPresenterImpl implements DisplayMealDetailsPresenter, NetworkCallback {
    private MealSearchView _view;
    private ProductsRepository _repo;

    public DisplayMealDetailsPresenterImpl(MealSearchView _view, ProductsRepository _repo) {
        this._view = _view;
        this._repo = _repo;
    }

    @Override
    public void onSuccessResult(List<POJO_class> myproducts) {
        _view.showMealDisplay(myproducts);
        Log.i("TAG", "cccccc");
    }

    @Override
    public void onFailureResult(String ErrorMsg) {
        Log.i("TAG", "qqqq");
    }

    @Override
    public void getProductsbyIngredient(String l_meal) {
        _repo.searchMealbyIngredient(this, l_meal);
        Log.i("TAG", "mmmm");
    }

    @Override
    public void getProductsbyCountry(String l_country) {
        _repo.searchMealbyCountry(this,l_country);
    }

    @Override
    public void getProductsbyCategory(String l_category) {
        _repo.searchMealbyCategory(this,l_category);
    }
}
