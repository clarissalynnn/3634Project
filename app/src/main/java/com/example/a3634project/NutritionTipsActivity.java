package com.example.a3634project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.a3634project.Adapters.NutritionTipsAdapter;
import com.example.a3634project.Adapters.RecipeAdapter;
import com.example.a3634project.Models.NutritionTips;
import com.example.a3634project.SpoonacularAPI.Recipe;

import java.util.ArrayList;

public class NutritionTipsActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private NutritionTipsAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_tips);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new NutritionTipsAdapter(NutritionTips.getNutritionTips());
        mRecyclerView.setAdapter(mAdapter);

    }
}
