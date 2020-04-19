package com.example.a3634project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RecipeDetailActivity extends AppCompatActivity {
    private TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        mTitle = findViewById(R.id.recipeTitleTv);

        Intent intent = getIntent();
        int position = intent.getIntExtra(RecipeActivity.EXTRA_MESSAGE, 0);

        /*mRecipe = Recipe.getRecipes().get(position);
        mTitle.setText(mRecipe.getTitle());*/
    }
}
