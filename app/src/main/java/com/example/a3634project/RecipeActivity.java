package com.example.a3634project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a3634project.Adapters.RecipeAdapter;
import com.example.a3634project.SpoonacularAPI.APIService;
import com.example.a3634project.SpoonacularAPI.Recipe;
import com.example.a3634project.SpoonacularAPI.RecipeResponse;
import com.example.a3634project.SpoonacularAPI.RecipeResponseOne;
import com.example.a3634project.SpoonacularAPI.Result;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeActivity extends AppCompatActivity {
    private Recipe mRecipe;
    private RecyclerView mRecyclerView;
    private RecipeAdapter mAdapter;
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

        mAdapter = new RecipeAdapter(new ArrayList<Result>(), listener);
        mRecyclerView.setAdapter(mAdapter);

        new GetRecipeTask().execute();
    }

    private void launchRecipeDetailActivity(int position){
        Intent intent = new Intent(this, RecipeDetailActivity.class);
        intent.putExtra(EXTRA_MESSAGE, position);
        startActivity(intent);
    }

    private class GetRecipeTask extends AsyncTask<Void, Void, List<Result>> {

        @Override
        protected List<Result> doInBackground(Void... voids) {
            try{
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService service = retrofit.create(APIService.class);
                Call<RecipeResponseOne> responseOneCall = service.getRecipe("100", "lunch");
                //Call<RecipeResponse> recipeCall = service.getRecipe("20","breakfast");
                //Call<RecipeResponse> recipeCall = service.getRandomRecipe();

                Response<RecipeResponseOne> recipeResponse = responseOneCall.execute();
                List<Result> recipeList = recipeResponse.body().getResults();
                return recipeList;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Result> recipeList) {
            mAdapter.setRecipes(recipeList);
        }

    }

}



