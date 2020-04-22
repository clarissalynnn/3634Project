package com.example.a3634project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.a3634project.Models.HealthyDiet;

public class HealthyDietDetailActivity extends AppCompatActivity {
    private HealthyDiet mDiet;
    TextView mDietType, mDietDescription, mAllowed, mNotAllowed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthy_diet_detail);

        mDietType = findViewById(R.id.dietTypeTv);
        mDietDescription = findViewById(R.id.dietDescriptionTv);
        mAllowed = findViewById(R.id.allowed);
        mNotAllowed = findViewById(R.id.notAllowed);

        Intent intent = getIntent();
        int position = intent.getIntExtra(HealthyDietActivity.EXTRA_MESSAGE,0);

        mDiet = HealthyDiet.getHealthyDiet().get(position);
        mDietType.setText(mDiet.getDietType());
        mDietDescription.setText(mDiet.getDietDescription());
        mAllowed.setText(mDiet.getAllowedIngredient());
        mNotAllowed.setText(mDiet.getNotAllowedIngredient());
    }
}
