package com.example.a3634project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a3634project.SpoonacularAPI.APIService;
import com.example.a3634project.SpoonacularAPI.ExtendedIngredient;
import com.example.a3634project.SpoonacularAPI.RecipeDetailResponse;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeDetailActivity extends AppCompatActivity {
    ImageView mImage;
    TextView mTitle, mLike, mServing, mReadyIn, mHealthScore, mSummary, mInstruction;
    ImageButton mLaunchUrl;
    private ProgressDialog progressDialog;
    public static final String ARG_ITEM_ID = "item_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);
        progressDialog.show();

        new GetRecipeDetailTask().execute();

        mImage = findViewById(R.id.recipeImageIv);
        mTitle = findViewById(R.id.recipeTitleTv);
        mLike = findViewById(R.id.likesTv);
        mServing = findViewById(R.id.servingTv);
        mReadyIn = findViewById(R.id.readyInTv);
        mHealthScore = findViewById(R.id.healthScoreTv);
        mSummary = findViewById(R.id.recipeSummaryTv);
        mInstruction = findViewById(R.id.recipeInstructionTv);
        mLaunchUrl = findViewById(R.id.launchUrlBt);

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
                List<ExtendedIngredient> extendedIngredientList = recipeDetail.getExtendedIngredients();
                return recipeDetail;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(RecipeDetailResponse recipeDetail) {
            Picasso.get().load(recipeDetail.getImage()).into(mImage);
            mTitle.setText(recipeDetail.getTitle());
            mLike.setText(String.valueOf(recipeDetail.getAggregateLikes()));
            mServing.setText(String.valueOf(recipeDetail.getServings()));
            mReadyIn.setText(String.valueOf(recipeDetail.getReadyInMinutes()));
            mHealthScore.setText(String.valueOf(recipeDetail.getHealthScore()));
            mSummary.setText(Html.fromHtml(String.valueOf(Html.fromHtml(recipeDetail.getSummary()))));
            mInstruction.setText(recipeDetail.getInstructions());
            mLaunchUrl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(recipeDetail.getSourceUrl()));
                    startActivity(intent);
                }
            });
            progressDialog.dismiss();
        }

    }

}
