package com.example.food_planner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealViewHolder> {

    private List<String> mealList;

    // Constructor to accept meal data
    public MealAdapter(List<String> mealList) {
        this.mealList = mealList;
    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for RecyclerView item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_meal, parent, false);
        return new MealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        // Bind the data to the TextView
        holder.mealName.setText(mealList.get(position));
    }

    @Override
    public int getItemCount() {
        // Return the size of the data list
        return mealList.size();
    }

    // ViewHolder class for RecyclerView item
    public static class MealViewHolder extends RecyclerView.ViewHolder {
        TextView mealName;

        public MealViewHolder(@NonNull View itemView) {
            super(itemView);
            mealName = itemView.findViewById(R.id.meal_name);
        }
    }
}
