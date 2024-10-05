package com.example.product_app_mvc.mealsSearch.Presenter;

import com.example.product_app_mvc.model.POJO_class;

public interface DisplayMealDetailsPresenter {
    public void getProductsbyIngredient(String l_meal);
    public void getProductsbyCountry(String l_country);
    public void getProductsbyCategory(String l_category);
//public void addToFav(POJO_class myProduct);

}
