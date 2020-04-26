package com.example.a3634project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.a3634project.Adapters.WaterAdapter;

import java.util.ArrayList;
import java.util.Random;

public class add_water extends AppCompatActivity {
    private TextView mWaterFacts;
    private TextView mIntakeInput;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    String [] waterFacts = {
            // facts are from https://www.health24.com/Diet-and-nutrition/Beverages/12-interesting-water-facts-20120721
            // 12 interesting facts about water 2019, Health24, viewed 22 April 2020, <https://www.health24.com/Diet-and-nutrition/Beverages/12-interesting-water-facts-20120721>
            "Did you know that our body is made up of 55 - 75% water?",
            "It is healthy to drink water while eating as it aids the process of digestion",
            "Good water intake prevents the skin from sagging",
            "Water is the main food that the body needs",
            "Water allows the body to metabolize fats more efficiently",
            "The best way to get rid of water retention is to drink more water",
            "Water retention can be a sign of dehydration"
    };
    Random random = new Random();
    int randomFacts = random.nextInt(waterFacts.length);
    String randomFacts1 = waterFacts[randomFacts];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_water);

        mWaterFacts = findViewById(R.id.waterFacts);
        mWaterFacts.setText(randomFacts1);
        mIntakeInput = findViewById(R.id.intakeInputWater);

        WaterAdapter.RecyclerViewClickListener listener = new WaterAdapter.RecyclerViewClickListener() {
            int intake = 0;
            @Override
            public void onClick(View view, int position) {
            switch(position){
                // When the first item in the recyclerview is clicked, update intakeInput by 250.
                case 0:
                intake += 250;
                mIntakeInput.setText(Integer.toString(intake) + " ml");
                break;
                // When the second item in the recyclerview is clicked, update intakeInput by 500.
                case 1:
                    intake += 500;
                    mIntakeInput.setText(Integer.toString(intake) + " ml");
                    break;
            }
            }
        };

        mRecyclerView = findViewById(R.id.waterRecyclerView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new WaterAdapter(waterListItem.getList(), listener);
        mRecyclerView.setAdapter(mAdapter);

    }


}
