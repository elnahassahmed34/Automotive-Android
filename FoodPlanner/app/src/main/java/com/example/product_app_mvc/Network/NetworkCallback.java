package com.example.product_app_mvc.Network;

import com.example.product_app_mvc.model.Category;
import com.example.product_app_mvc.model.POJO_class;

import java.util.List;

public interface NetworkCallback {

    public void onSuccessResult(List<POJO_class> myproducts);
    public void onFailureResult(String ErrorMsg);
    public void onSuccessResultcat(List<Category> Categries);
    public void onFailureResultcat(String ErrorMsg);

}
