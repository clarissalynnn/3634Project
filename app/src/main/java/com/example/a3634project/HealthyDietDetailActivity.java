package com.example.a3634project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.a3634project.Adapters.RecipeAdapter;
import com.example.a3634project.Models.HealthyDiet;
import com.example.a3634project.SpoonacularAPI.APIService;
import com.example.a3634project.SpoonacularAPI.Recipe;
import com.example.a3634project.SpoonacularAPI.RecipeResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HealthyDietDetailActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecipeAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
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

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecipeAdapter(new ArrayList<Recipe>());
        mRecyclerView.setAdapter(mAdapter);

        new GetRecipeTask().execute(mDiet.getDietType());
    }

    private class GetRecipeTask extends AsyncTask<String, Void, List<Recipe>> {

        @Override
        protected List<Recipe> doInBackground(String... params) {
            String dietType = params[0];
            try{
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService service = retrofit.create(APIService.class);
                Call<RecipeResponse> recipeCall = service.getRecipe("10", dietType);
                Response<RecipeResponse> recipeResponse = recipeCall.execute();
                List<Recipe> recipeList = recipeResponse.body().getRecipes();
                return recipeList;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Recipe> recipeList) {
            mAdapter.setRecipes(recipeList);
        }

    }
}
