package com.example.product_app_mvc.Network;



import com.example.product_app_mvc.model.ProductsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

// Interface for the Products API
public interface ProductService {
    // Get all products or apply a limit query if needed
    @GET("random.php")
    Call<ProductsResponse> getProducts();


    @POST("filter.php")
    Call<ProductsResponse> searchMealbyIngredient(@Query("i") String mealName);//search by Ingredient

    @POST("filter.php")
    Call<ProductsResponse> searchMealbyCountry(@Query("a") String CountryName);//search by Country

    @POST("filter.php")
    Call<ProductsResponse> searchMealbyCategory(@Query("c") String CountryName);//search by Category

}
