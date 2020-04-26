package com.example.a3634project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class add_food extends AppCompatActivity {

    //following code adapted from: https://www.studytonight.com/android/get-edittext-set-textview

    public EditText mBreakfastInput;
    public EditText mLunchInput;
    public EditText mDinnerInput;
    public EditText mSnacksInput;

    public Button mSaveBreakfast;
    public Button mSaveLunch;
    public Button mSaveDinner;
    public Button mSaveSnacks;

    public TextView mBreakfastDisplay;
    public TextView mLunchDisplay;
    public TextView mDinnerDisplay;
    public TextView mSnacksDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        mBreakfastInput = findViewById(R.id.breakfastInput);
        mLunchInput = findViewById(R.id.lunchInput);
        mDinnerInput = findViewById(R.id.dinnerInput);
        mSnacksInput = findViewById(R.id.snacksInput);

        mSaveBreakfast = findViewById(R.id.saveBreakfast);
        mSaveLunch = findViewById(R.id.saveLunch);
        mSaveDinner = findViewById(R.id.saveDinner);
        mSaveSnacks = findViewById(R.id.saveSnacks);

        mBreakfastDisplay = findViewById(R.id.breakfastDisplay);
        mLunchDisplay = findViewById(R.id.lunchDisplay);
        mDinnerDisplay = findViewById(R.id.dinnerDisplay);
        mSnacksDisplay = findViewById(R.id.snacksDisplay);

        mSaveBreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String breakfast = mBreakfastInput.getText().toString();
                mBreakfastDisplay.setText(breakfast);
            }
        });

        mSaveLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lunch = mLunchInput.getText().toString();
                mLunchDisplay.setText(lunch);

            }
        });

        mSaveDinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dinner = mDinnerInput.getText().toString();
                mDinnerDisplay.setText(dinner);

            }
        });

        mSaveSnacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String snacks = mSnacksInput.getText().toString();
                mSnacksDisplay.setText(snacks);
            }
        });
    }
}
