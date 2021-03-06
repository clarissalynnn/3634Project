package com.example.a3634project.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3634project.Adapters.TopicAdapter;
import com.example.a3634project.HealthyDietActivity;
import com.example.a3634project.IngredientActivity;
import com.example.a3634project.NutritionTipsActivity;
import com.example.a3634project.R;
import com.example.a3634project.Models.Topic;
import com.example.a3634project.RecipeActivity;
import com.example.a3634project.SearchIngredientsData;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExploreFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public ExploreFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_explore, container, false);

        mRecyclerView = v.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(getActivity(),2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        TopicAdapter.RecyclerViewClickListener listener = new TopicAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                switch(position){
                    case 0:
                        launchCuisineActivity();
                        break;
                    case 1:
                        launchIngredientActivity();
                        break;
                    case 2:
                        launchNutritionTipsActivity();
                        break;
                    case 3:
                        launchHealthyDietActivity();
                        break;
                }
            }
        };

        mAdapter = new TopicAdapter(Topic.getTopics(), listener);
        mRecyclerView.setAdapter(mAdapter);

        return v;
    }

    private void launchCuisineActivity(){
        Intent intent = new Intent(getActivity(), RecipeActivity.class);
        startActivity(intent);
    }

    private void launchIngredientActivity(){
        Intent intent = new Intent(getActivity(), SearchIngredientsData.class);
        startActivity(intent);
    }

    private void launchNutritionTipsActivity(){
        Intent intent = new Intent(getActivity(), NutritionTipsActivity.class);
        startActivity(intent);
    }

    private void launchHealthyDietActivity(){
        Intent intent = new Intent(getActivity(), HealthyDietActivity.class);
        startActivity(intent);
    }
}
