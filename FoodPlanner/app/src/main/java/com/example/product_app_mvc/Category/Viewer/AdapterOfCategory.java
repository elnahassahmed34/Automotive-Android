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
import com.example.product_app_mvc.mealsSearch.Viewer.OnItemClickListener;
import com.example.product_app_mvc.model.Category;
import com.example.product_app_mvc.model.POJO_class;

import java.util.ArrayList;
import java.util.List;

public class AdapterOfCategory extends RecyclerView.Adapter<AdapterOfCategory.ViewHolder> {

    private String[] localDataSet;
    private Context _context;
    private List<Category> myDataSet;
    private OnItemClickListenerCat myOnItemClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //private final TextView textView;

        private TextView tvCategoryName;
        public ImageView ivCategoryImage;
        public ViewHolder(View view) {
            super(view);
            tvCategoryName = view.findViewById(R.id.tvCategoryName);
            ivCategoryImage = view.findViewById(R.id.ivCategoryImage);
        }

        public void bind(final Category item, final OnItemClickListenerCat listener) {
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

    //String[] data

    public void setList(List<Category> myDataSet)
    {
        this.myDataSet = myDataSet;
    }
    public AdapterOfCategory(Context _context , OnItemClickListenerCat l_OnItemClickListener ) {
        //localDataSet = dataSet;
        this._context = _context;
        myDataSet = new ArrayList<>();
        this.myOnItemClickListener = l_OnItemClickListener;
        Log.i("TAG", "www");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_category, viewGroup, false);
        Log.i("TAG", "zzz");
        Log.i("TAG", "=== onCreateViewHolder ===");

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, @SuppressLint("RecyclerView") final int position) {
        viewHolder.tvCategoryName.setText(myDataSet.get(position).getStrCategory());
        //Log.i("TAG", "ddd");
        //Log.i("TAG", myDataSet.get(position).getStrMeal());
        Glide.with(_context)
                .load(myDataSet.get(position).getStrCategoryThumb())
                .apply(new RequestOptions()
                        .override(200, 200)
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .error(R.drawable.ic_launcher_foreground))
                .into(viewHolder.ivCategoryImage);

        // Set the click listener for the item

        // Set onClickListener on the itemView
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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
        Log.i("TAG", "datasetcount");
        return myDataSet.size();
    }
}
