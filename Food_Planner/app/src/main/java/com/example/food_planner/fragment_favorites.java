package com.example.food_planner;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.food_planner.MealAdapter;
import com.example.food_planner.R;
import java.util.ArrayList;
import java.util.List;

public class fragment_favorites extends Fragment {

    private RecyclerView recyclerView;
    private MealAdapter mealAdapter;
    private List<String> mealList;

    public fragment_favorites() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_favorites);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Prepare dummy data
        mealList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            mealList.add("Favorite Meal " + i);
        }

        // Set the adapter with the dummy data
        mealAdapter = new MealAdapter(mealList);
        recyclerView.setAdapter(mealAdapter);

        return view;
    }
}
