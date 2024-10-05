package com.example.product_app_mvc.Network;

import android.content.Context;
import android.util.Log;

import com.example.product_app_mvc.model.CategoryResponse;
import com.example.product_app_mvc.model.POJO_class;
import com.example.product_app_mvc.model.ProductsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductsRemoteDataSourceImpl implements ProductsRemoteDataSource {
    private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    private static ProductsRemoteDataSourceImpl instance;
    private ProductService productsApi;
    private Call<ProductsResponse> call;
    private Call<CategoryResponse> call2;
    // Constructor
    private ProductsRemoteDataSourceImpl(Context context) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL).build();
        productsApi = retrofit.create(ProductService.class);
        //executorService = Executors.newSingleThreadExecutor(); // For background tasks

    }

    // Get RetrofitClient instance
    public static synchronized ProductsRemoteDataSourceImpl getInstance(Context context) {
        if (instance == null) {
            instance = new ProductsRemoteDataSourceImpl(context);
        }
        return instance;
    }

    // Fetch products from the API
    public void fetchAndStoreProducts(NetworkCallback myNetworkCallback) {
        call = productsApi.getProducts();
        call.enqueue(new Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {

                    myNetworkCallback.onSuccessResult(response.body().getProducts());
                    Log.i("RetrofitClient", "here");
                    Log.i("RetrofitClient", response.body().getProducts().get(0).getIdMeal());

                } else {
                    Log.e("RetrofitClient", "API call failed");
                }
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {
                myNetworkCallback.onFailureResult(t.getMessage());
                Log.e("RetrofitClient", "API call error: " + t.getMessage());
            }
        });
    }

    public void searchForMealbyIngredient(NetworkCallback myNetworkCallback, String mealName) {
        call = productsApi.searchMealbyIngredient(mealName);

        call.enqueue(new retrofit2.Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, retrofit2.Response<ProductsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<POJO_class> meals = response.body().getProducts();
                    // Handle the meal data here

                    myNetworkCallback.onSuccessResult(response.body().getProducts());

                    //for (POJO_class meal : meals) {
                    //    Log.i("TAG", "ccccccccccccc");
                    //    Log.i("Meal", "Meal Name: " + meal.getStrMeal());
                    //    Log.i("Meal", "Meal Name: " + meal.getStrCategory());
                    //    // Do something with the meal data
                    //}
                } else {
                    Log.e("API_ERROR", "Response unsuccessful or body is null");
                }
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {
                myNetworkCallback.onFailureResult("No Response");
                Log.e("API_ERROR", "Request failed: " + t.getMessage());
            }
        });
    }

    @Override
    public void searchForMealbyCountry(NetworkCallback myNetworkCallback, String CountryName) {
        call = productsApi.searchMealbyCountry(CountryName);

        call.enqueue(new retrofit2.Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, retrofit2.Response<ProductsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<POJO_class> meals = response.body().getProducts();
                    // Handle the meal data here

                    myNetworkCallback.onSuccessResult(response.body().getProducts());

                    //for (POJO_class meal : meals) {
                    Log.i("TAG", "ccccppc");
                    //    Log.i("Meal", "Meal Name: " + meal.getStrMeal());
                    //    Log.i("Meal", "Meal Name: " + meal.getStrCategory());
                    //    // Do something with the meal data
                    //}
                } else {
                    Log.e("API_ERROR", "Response unsuccessful or body is null");
                }
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {
                myNetworkCallback.onFailureResult("No Response");
                Log.e("API_ERROR", "Request failed: " + t.getMessage());
            }
        });
    }

    @Override
    public void searchForMealbyCategory(NetworkCallback myNetworkCallback, String CategoryName) {
        call = productsApi.searchMealbyCategory(CategoryName);

        call.enqueue(new retrofit2.Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, retrofit2.Response<ProductsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<POJO_class> meals = response.body().getProducts();
                    // Handle the meal data here

                    Log.i("TAG", "vgvj");
                    Log.i("TAG", response.body().getProducts().get(0).getStrMeal());
                    myNetworkCallback.onSuccessResult(response.body().getProducts());

                    //for (POJO_class meal : meals) {

                    //    Log.i("Meal", "Meal Name: " + meal.getStrMeal());
                    //    Log.i("Meal", "Meal Name: " + meal.getStrCategory());
                    //    // Do something with the meal data
                    //}
                } else {
                    Log.e("API_ERROR", "Response unsuccessful or body is null");
                }
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {
                myNetworkCallback.onFailureResult("No Response");
                Log.e("API_ERROR", "Request failed: " + t.getMessage());
            }
        });
    }

    public void fetchcategory(NetworkCallback myNetworkCallback) {

        call2 = productsApi.getCategories();
        call2.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                if (response.isSuccessful() && response.body() != null) {

                    myNetworkCallback.onSuccessResultcat(response.body().getCategories());
                    Log.i("RetrofitClient", "here");
                    Log.i("RetrofitClient", response.body().getCategories().get(0).getStrCategory());

                } else {
                    Log.e("RetrofitClient", "API call failed");
                }
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                myNetworkCallback.onFailureResultcat(t.getMessage());
                Log.e("RetrofitClient", "API call error: " + t.getMessage());
            }


        });

    }

    public void fetchMealDetails(NetworkCallback myNetworkCallback, int l_mealID) {
        call = productsApi.getMealDetails(l_mealID);
        call.enqueue(new Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {

                    myNetworkCallback.onSuccessResult(response.body().getProducts());
                    Log.i("RetrofitClient", "here");
                } else {
                    Log.e("RetrofitClient", "API call failed");
                }
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {
                myNetworkCallback.onFailureResult(t.getMessage());
                Log.e("RetrofitClient", "API call error: " + t.getMessage());
            }
        });



    }



}
