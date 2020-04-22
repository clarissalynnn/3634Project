package com.example.a3634project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a3634project.SpoonacularAPI.APIService;
import com.example.a3634project.SpoonacularAPI.RecipeDetailResponse;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.text.NumberFormat;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeDetailActivity extends AppCompatActivity {
    ImageView mImage;
    TextView mTitle, mLike, mServing, mReadyIn, mHealthScore, mSummary, mInstruction;
    public static final String ARG_ITEM_ID = "item_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        new GetRecipeDetailTask().execute();

        mImage = findViewById(R.id.recipeImageIv);
        mTitle = findViewById(R.id.recipeTitleTv);
        mLike = findViewById(R.id.likesTv);
        mServing = findViewById(R.id.servingTv);
        mHealthScore = findViewById(R.id.healthScoreTv);
        mSummary = findViewById(R.id.recipeSummaryTv);
        mInstruction = findViewById(R.id.recipeInstructionTv);

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
            //NumberFormat formatter = NumberFormat.getCurrencyInstance();
            Picasso.get().load(recipeDetail.getImage()).into(mImage);
            mTitle.setText(recipeDetail.getTitle());
            mLike.setText(String.valueOf(recipeDetail.getAggregateLikes()));
            mServing.setText(String.valueOf(recipeDetail.getServings()));
            //mReadyIn.setText(formatter.format(Integer.valueOf(recipeDetail.getReadyInMinutes())));
            mHealthScore.setText(String.valueOf(recipeDetail.getHealthScore()));
            mSummary.setText(Html.fromHtml(String.valueOf(Html.fromHtml(recipeDetail.getSummary()))));
            mInstruction.setText(recipeDetail.getInstructions());
        }

    }
}
