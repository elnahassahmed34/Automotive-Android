package com.example.product_app_mvc.Random.Viewer.Viewer;


import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.product_app_mvc.DB.ProductsLocalDataSourceImpl;
import com.example.product_app_mvc.Random.Presenter.DisplayMealDetailsPresenterImpl;
import com.example.product_app_mvc.Network.ProductsRemoteDataSourceImpl;
import com.example.product_app_mvc.R;
import com.example.product_app_mvc.model.ProductsRepositoryImpl;
import com.example.product_app_mvc.model.POJO_class;

import java.util.List;



public class MealDetailsActivity extends AppCompatActivity implements MealDetailsView, if_AddFavProduct {

    private static final String YOUTUBE_PREFIX = "https://www.youtube.com/";
    private TextView txt_meal_name;
    private ImageView img_meal;
    private TextView txt_origin_country;
    private TextView txt_steps;
    private TextView txt_ingredients;
    private VideoView video_view;
    private Button btn_favorite;
    private WebView webView ;

    DisplayMealDetailsPresenterImpl myDisplayMealDetailsPresenterImpl;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.recycle_layout);

        txt_meal_name = findViewById(R.id.txt_meal_name);
        img_meal = findViewById(R.id.img_meal);
        txt_origin_country = findViewById(R.id.txt_origin_country);
        txt_steps = findViewById(R.id.txt_steps);
        txt_ingredients = findViewById(R.id.txt_ingredients);
        webView = findViewById(R.id.webView);
        btn_favorite = findViewById(R.id.btn_favorite);

        myDisplayMealDetailsPresenterImpl = new DisplayMealDetailsPresenterImpl(
                this,
                ProductsRepositoryImpl.getInstance(
                        ProductsRemoteDataSourceImpl.getInstance(this),
                        ProductsLocalDataSourceImpl.getInstance(this)
                )
        );

        String mealid = getIntent().getStringExtra("code");

        if(mealid.equals("null"))
            myDisplayMealDetailsPresenterImpl.getMealDetails();
        else
            myDisplayMealDetailsPresenterImpl.getMealDetailsID(Integer.valueOf(getIntent().getStringExtra("meal_ID")));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void showMealDisplay(List<POJO_class> l_list) {
        if (l_list != null) {
            txt_meal_name.setText(l_list.get(0).getStrMeal());
            txt_origin_country.setText(l_list.get(0).getStrArea());
            txt_steps.setText(l_list.get(0).getStrInstructions());
            String temp = l_list.get(0).getStrIngredient1() + " " +
                    l_list.get(0).getStrIngredient2() + " " +
                    l_list.get(0).getStrIngredient3() + " " +
                    l_list.get(0).getStrIngredient4();

            setupWebView(l_list);

            txt_ingredients.setText(temp);

            Glide.with(this)
                    .load(l_list.get(0).getStrMealThumb())
                    .apply(new RequestOptions()
                            .override(200, 200)
                            .placeholder(R.drawable.ic_launcher_foreground)
                            .error(R.drawable.ic_launcher_foreground))
                    .into(this.img_meal);


            btn_favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onFavAddclick(l_list.get(0));
                    // holder.btnAddToFav.setBackgroundColor(0x03A9F4FF);
                }
            });
        }
    }

    @Override
    public void onFavAddclick(POJO_class favProduct) {
        myDisplayMealDetailsPresenterImpl.addToFav(favProduct);

    }

    private void setupWebView(List<POJO_class> l_list) {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return !(url.startsWith(YOUTUBE_PREFIX + "watch") || url.startsWith(YOUTUBE_PREFIX + "embed/"));
            }
        });

        String youtubeEmbedUrl = "https://www.youtube.com/embed/" + getYoutubeVideoId(l_list.get(0).getStrYoutube());
        webView.loadUrl(youtubeEmbedUrl);

    }

    private String getYoutubeVideoId(String url) {
        if (TextUtils.isEmpty(url)) return "";

        Uri uri = Uri.parse(url);
        String videoId = uri.getQueryParameter("v");

        if (videoId == null) {
            videoId = uri.getLastPathSegment();
        }
        return videoId != null ? videoId : "";
    }
}
