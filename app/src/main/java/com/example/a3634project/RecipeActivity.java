package com.example.a3634project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;

import com.example.a3634project.Adapters.RecipeAdapter;
import com.example.a3634project.SpoonacularAPI.Recipe;

public class RecipeActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static final String EXTRA_MESSAGE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        RecipeAdapter.RecyclerViewClickListener listener = new RecipeAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                launchRecipeDetailActivity(position);
            }
        };

        mAdapter = new RecipeAdapter(Recipe.getRecipes(), listener);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void launchRecipeDetailActivity(int position){
        Intent intent = new Intent(this, RecipeDetailActivity.class);
        intent.putExtra(EXTRA_MESSAGE, position);
        startActivity(intent);
    }

}
