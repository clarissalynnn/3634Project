package com.example.a3634project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;

import com.example.a3634project.Adapters.HealthyDietAdapter;
import com.example.a3634project.Adapters.NutritionTipsAdapter;
import com.example.a3634project.Models.HealthyDiet;
import com.example.a3634project.Models.NutritionTips;

public class HealthyDietActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private HealthyDietAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static final String EXTRA_MESSAGE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthy_diet);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        HealthyDietAdapter.RecyclerViewClickListener listener = new HealthyDietAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                launchHealthyDietDetailActivity(position);
            }
        };

        mAdapter = new HealthyDietAdapter(HealthyDiet.getHealthyDiet(), listener);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void launchHealthyDietDetailActivity(int position){
        Intent intent = new Intent(this, HealthyDietDetailActivity.class);
        intent.putExtra(EXTRA_MESSAGE, position);
        startActivity(intent);
    }

}
