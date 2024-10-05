package com.example.product_app_mvc.FavProducts.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.product_app_mvc.R;
import com.example.product_app_mvc.model.POJO_class;

import java.util.ArrayList;
import java.util.List;

class FavProductAdapter extends RecyclerView.Adapter<FavProductAdapter.ViewHolder> {

    private static final String YOUTUBE_PREFIX = "https://www.youtube.com/";
    private final Context context;
    private List<POJO_class> myDataSet;
    if_DeleteFavProduct myif_deletefavproduct;

    public FavProductAdapter(Context context, if_DeleteFavProduct l_ref) {
        this.context = context;
        this.myif_deletefavproduct = l_ref;
        myDataSet = new ArrayList<>();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setAdapter(List<POJO_class> myDataSet) {
        this.myDataSet = myDataSet;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_meal_name;
        private ImageView img_meal;
        private TextView txt_origin_country;
        private TextView txt_ingredients;
        private TextView txt_steps;
        private WebView webView;
        private Button btn_delete;
        public ConstraintLayout constraintLayout;

        public ViewHolder(View v) {
            super(v);
            txt_meal_name = v.findViewById(R.id.txt_meal_name);
            img_meal = v.findViewById(R.id.img_meal);
            txt_origin_country = v.findViewById(R.id.txt_origin_country);
            txt_ingredients = v.findViewById(R.id.txt_ingredients);
            txt_steps = v.findViewById(R.id.txt_steps);
            webView = v.findViewById(R.id.webView);
            btn_delete = v.findViewById(R.id.btn_delete);
            constraintLayout = v.findViewById(R.id.main);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup recyclerView, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(recyclerView.getContext());
        View v = inflater.inflate(R.layout.fav_recycle_layout, recyclerView, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if (myDataSet != null && !myDataSet.isEmpty()) {
            POJO_class product = myDataSet.get(position);
            // Bind data to the views
            holder.txt_meal_name.setText(product.getStrMeal());

            // Concatenate multiple ingredients
            String ingredients = product.getStrIngredient1() + ", " +
                    product.getStrIngredient2() + ", " +
                    product.getStrIngredient3();
            holder.txt_ingredients.setText(ingredients);

            holder.txt_origin_country.setText(product.getStrArea());

            // Limit the display size of steps to 3 lines and add a "Read More" button for full text
            holder.txt_steps.setMaxLines(3);
            holder.txt_steps.setEllipsize(TextUtils.TruncateAt.END);
            holder.txt_steps.setText(product.getStrInstructions());

            // Load the meal image using Glide
            Glide.with(context)
                    .load(product.getStrMealThumb())
                    .apply(new RequestOptions()
                            .override(200, 200)
                            .placeholder(R.drawable.ic_launcher_foreground)
                            .error(R.drawable.ic_launcher_foreground))
                    .into(holder.img_meal);

            // Set up WebView content (for YouTube video)
            setupWebView(holder.webView, product.getStrYoutube());

            // Handle delete button click
            holder.btn_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("TAG","343545342232242");
                    myif_deletefavproduct.onFavdeleteclick(product);

                    Log.i("TAG", product.getIdMeal());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return myDataSet.size();
    }

    private void setupWebView(WebView webView, String youtubeUrl) {
        if (!TextUtils.isEmpty(youtubeUrl)) {
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    return !(url.startsWith(YOUTUBE_PREFIX + "watch") || url.startsWith(YOUTUBE_PREFIX + "embed/"));
                }
            });

            String youtubeEmbedUrl = "https://www.youtube.com/embed/" + getYoutubeVideoId(youtubeUrl);
            webView.loadUrl(youtubeEmbedUrl);
        }
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
