package com.example.a3634project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.example.a3634project.SpoonacularAPI.APIService;
import com.example.a3634project.SpoonacularAPI.Recipe;
import com.example.a3634project.SpoonacularAPI.RecipeDetailResponse;
import com.example.a3634project.SpoonacularAPI.RecipeResponse;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeDetailActivity extends AppCompatActivity {
    TextView mTitle, mSummary;
    public static final String ARG_ITEM_ID = "item_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        new GetRecipeDetailTask().execute();

        mTitle = findViewById(R.id.recipeTitleTv);
        mSummary = findViewById(R.id.recipeSummaryTv);

        /*Intent intent = getIntent();
        int position = intent.getIntExtra(RecipeActivity.EXTRA_MESSAGE, 0);

        /*mRecipe = Recipe.getRecipes().get(position);
        mTitle.setText(mRecipe.getTitle());*/
    }

    private class GetRecipeDetailTask extends AsyncTask<Void, Void, RecipeDetailResponse> {

        @Override
        protected RecipeDetailResponse doInBackground(Void... voids) {
            int recipeId = getIntent().getExtras().getInt("RECIPE_ID");
            try{
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService service = retrofit.create(APIService.class);
                Call<RecipeDetailResponse> recipeDetailCall = service.getRecipeDetail(recipeId);
                Response<RecipeDetailResponse> recipeDetailResponse = recipeDetailCall.execute();
                RecipeDetailResponse recipeDetail = recipeDetailResponse.body();
                return recipeDetail;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(RecipeDetailResponse recipeDetail) {
            mTitle.setText(recipeDetail.getTitle());
            mSummary.setText(recipeDetail.getSummary());
        }

    }
}
