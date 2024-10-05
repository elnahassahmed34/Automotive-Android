package com.example.product_app_mvc.Network;

public interface ProductsRemoteDataSource {

    public void fetchAndStoreProducts(NetworkCallback myNetworkCallback);

    public void searchForMealbyIngredient(NetworkCallback myNetworkCallback, String mealName);

    public void searchForMealbyCountry(NetworkCallback myNetworkCallback, String CountryName);

    public void searchForMealbyCategory(NetworkCallback myNetworkCallback, String CategoryName);

    public void fetchcategory(NetworkCallback myNetworkCallback);

    public void fetchMealDetails(NetworkCallback myNetworkCallback, int l_mealID);

}
