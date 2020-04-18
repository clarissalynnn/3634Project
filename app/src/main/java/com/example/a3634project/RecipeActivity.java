package com.example.a3634project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3634project.Adapters.TopicAdapter;
import com.example.a3634project.Models.Topic;

public class RecipeActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        mRecyclerView = findViewById(R.id.cuisineRV);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        TopicAdapter.RecyclerViewClickListener listener = new TopicAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                switch(position){
                    case 0:
                        launchRecipeActivity();
                        break;
                }
            }
        };

        mAdapter = new TopicAdapter(Topic.getTopics(), listener);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void launchRecipeActivity(){
        Intent intent = new Intent(this, RecipeActivity.class);
        startActivity(intent);
    }
}
