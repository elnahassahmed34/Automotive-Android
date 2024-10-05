package com.example.product_app_mvc.Category.Viewer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.product_app_mvc.R;
import com.example.product_app_mvc.mealsSearch.Viewer.AdapterOfSearchFragment;
import com.example.product_app_mvc.mealsSearch.Viewer.OnItemClickListener;
import com.example.product_app_mvc.model.Category;
import com.example.product_app_mvc.model.POJO_class;

import java.util.ArrayList;
import java.util.List;

public class CategoryMealsAdapter extends RecyclerView.Adapter<CategoryMealsAdapter.ViewHolder> {

    private String[] localDataSet;
    private Context _context;
    private List<POJO_class> myDataSet;
    private OnItemClickListnerCatMeals myOnItemClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //private final TextView textView;

        private TextView txt_meal_name;
        public ImageView img;
        public ViewHolder(View view) {
            super(view);
            txt_meal_name = view.findViewById(R.id.tvCategoryName);
            img = view.findViewById(R.id.ivCategoryImage);
        }

        public void bind(final POJO_class item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);  // Pass the clicked item to the listener
                }
            });
        }

        //public TextView getTextView() {
        //    return textView;
        //}
    }


    public void setList(List<POJO_class> myDataSet)
    {
        Log.i("TAG", "www");
        Log.i("TAG", myDataSet.get(0).getStrMeal());
        this.myDataSet = myDataSet;
    }

    public CategoryMealsAdapter(Context _context , OnItemClickListnerCatMeals l_OnItemClickListener ) {
        //localDataSet = dataSet;
        this._context = _context;
        myDataSet = new ArrayList<>();
        this.myOnItemClickListener = l_OnItemClickListener;
        Log.i("TAG", "www");
    }

    @NonNull
    @Override
    public CategoryMealsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category, parent, false);
        Log.i("TAG", "zzz");
        Log.i("TAG", "=== onCreateViewHolder ===");

        return new CategoryMealsAdapter.ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull CategoryMealsAdapter.ViewHolder holder, int position) {

       if (null != myDataSet)
       {
           holder.txt_meal_name.setText(myDataSet.get(position).getStrMeal());
           Log.i("TAG", "ddd");
           Log.i("TAG", myDataSet.get(position).getStrMeal());
           Glide.with(_context)
                   .load(myDataSet.get(position).getStrMealThumb())
                   .apply(new RequestOptions()
                           .override(200, 200)
                           .placeholder(R.drawable.ic_launcher_foreground)
                           .error(R.drawable.ic_launcher_foreground))
                   .into(holder.img);
       }



        // Set the click listener for the item

        // Set onClickListener on the itemView
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myOnItemClickListener != null) {
                    //Log.d("Adapter", "Item clicked: " + myDataSet.getStrMeal());
                    myOnItemClickListener.onItemClick(myDataSet.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return myDataSet.size();
    }
}