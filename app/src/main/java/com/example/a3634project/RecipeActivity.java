package com.example.a3634project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.a3634project.Adapters.RecipeAdapter;
import com.example.a3634project.SpoonacularAPI.APIService;
import com.example.a3634project.SpoonacularAPI.RecipeResponse;
import com.example.a3634project.SpoonacularAPI.Recipe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private RecyclerView mRecyclerView;
    private RecipeAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Spinner mSpinner;
    private ArrayAdapter<CharSequence> mAdapter1;
    public static final String EXTRA_MESSAGE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        mSpinner = findViewById(R.id.spinner);
        mAdapter1 = ArrayAdapter.createFromResource(this, R.array.recipeCuisine, android.R.layout.simple_spinner_item);
        mAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(mAdapter1);
        mSpinner.setOnItemSelectedListener(this);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecipeAdapter(new ArrayList<Recipe>());
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        new GetRecipeTask().execute(text);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private class GetRecipeTask extends AsyncTask<String, Void, List<Recipe>> {

        @Override
        protected List<Recipe> doInBackground(String... params) {
            String cuisine = params[0];
            try{
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService service = retrofit.create(APIService.class);
                Call<RecipeResponse> recipeCall = service.getRecipe("100", cuisine);
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



