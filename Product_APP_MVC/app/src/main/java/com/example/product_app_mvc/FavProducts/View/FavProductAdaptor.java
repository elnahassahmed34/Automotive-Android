package com.example.product_app_mvc.FavProducts.View;



import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.product_app_mvc.R;
import com.example.product_app_mvc.model.POJO_class;

import java.util.ArrayList;
import java.util.List;

class FavProductAdapter extends RecyclerView.Adapter<FavProductAdapter.ViewHolder> {


    private final Context context;

    private static final String TAG = "RecyclerView";
    private List<POJO_class> myDataSet;
    if_DeleteFavProduct myif_deletefavproduct;
    int temp;
    public FavProductAdapter(Context context , if_DeleteFavProduct l_ref)
    {

        this.context = context;;
        this.myDataSet = myDataSet;;
        this.myif_deletefavproduct = l_ref;
        myDataSet = new ArrayList<>();
        //Log.i("TAG", myDataSet.toString());
        //notifyDataSetChanged();
    }

   // public setlist()

    @SuppressLint("NotifyDataSetChanged")
    public void setadapter(List<POJO_class> myDataSet)
    {
        this.myDataSet = myDataSet;;
        //Log.i("TAG", myDataSet.toString());
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView   txt_meal_name;
        private ImageView  img_meal;
        private TextView   txt_origin_country;
        private TextView   txt_steps;
        private TextView   txt_ingredients;
        private VideoView video_view;
        private Button     btn_favorite;

        public ConstraintLayout constraintLayout;
        public View layout;

        @SuppressLint("WrongViewCast")
        public ViewHolder(View v) {
            super(v);

            layout = v;
            txt_meal_name = v.findViewById(R.id.txt_meal_name);
            img_meal = v.findViewById(R.id.img_meal);
            txt_origin_country = v.findViewById(R.id.txt_origin_country);
            txt_steps = v.findViewById(R.id.txt_steps);
            txt_ingredients = v.findViewById(R.id.txt_ingredients);
            video_view = v.findViewById(R.id.video_view);
            btn_favorite = v.findViewById(R.id.btn_favorite);
            constraintLayout = v.findViewById(R.id.search);




        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup recyclerView, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(recyclerView.getContext());
        View v = inflater.inflate(R.layout.fav_recycle_layout, recyclerView, false);
        ViewHolder vh = new ViewHolder(v);
        Log.i(TAG, "=== onCreateViewHolder ===");
        //return vh;
        return vh;
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if(myDataSet != null )
        {
           this.temp = myDataSet.size();
           holder.txt_meal_name.setText(myDataSet.get(position).getStrMeal());
           String temp = myDataSet.get(0).getStrIngredient1() + " " +
                   myDataSet.get(0).getStrIngredient2() + " " +
                   myDataSet.get(0).getStrIngredient3() + " " +
                   myDataSet.get(0).getStrIngredient4();
          // holder.txt_ingredients.setText(temp);
           //holder.txt_origin_country.setText(myDataSet.get(position).toString());
           //holder.txt_steps.setText(myDataSet.get(position).getStrInstructions());
           //holder.ratingBarr.setRating(Float.parseFloat(myDataSet.get(position).getRating()));
           //float rating = (float) ((myDataSet.get(position).getRating()) /2);
           //holder.ratingBarr.setRating(rating);

           Glide.with(context)
                   .load(myDataSet.get(position).getStrMealThumb())
                   .apply(new RequestOptions()
                           .override(200, 200)
                           .placeholder(R.drawable.ic_launcher_foreground)
                           .error(R.drawable.ic_launcher_foreground))
                   .into(holder.img_meal); // Use holder.imageView instead of holder.itemView

            holder.btn_favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myif_deletefavproduct.onFavdeleteclick(myDataSet.get(position));
                    //Toast.makeText(this ,"Deleted" , Toast.LENGTH_SHORT).show();

                }
            });
        }


    }
    @Override
    public int getItemCount() {
        return myDataSet.size();
    }

}


