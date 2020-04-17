package com.example.a3634project.Fragments;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a3634project.Adapters.TopicAdapter;
import com.example.a3634project.R;
import com.example.a3634project.Models.Topic;
import com.example.a3634project.Models.User;
import com.example.a3634project.SpoonacularAPI.JokeResponse;
import com.example.a3634project.SpoonacularAPI.RecipeResponse;
import com.example.a3634project.SpoonacularAPI.APIService;

import java.io.IOException;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private User user;
    private String TAG;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        new GetRecipeTask().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        user = (User) getActivity().getIntent().getSerializableExtra("User");
        mRecyclerView = v.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        TextView greetings = v.findViewById(R.id.greetingsTv);
        greetings.setText(setGreetings() + " " + user.getFirst_name() + "!");

        TopicAdapter.RecyclerViewClickListener listener = new TopicAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {

            }
        };

        return v;
    }

    private class GetRecipeTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            try{
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService service = retrofit.create(APIService.class);
                Call<RecipeResponse> recipeCall = service.getRecipe();

                Response<RecipeResponse> recipeResponse = recipeCall.execute();
                String recipe = recipeResponse.body().getRecipes().get(0).getTitle();
                return recipe;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String recipe) {
            TextView title = getActivity().findViewById(R.id.recipeTitleTv);
            title.setText(recipe);
        }
    }

    public String setGreetings(){
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
        String greetings = "";
        if(timeOfDay >= 0 && timeOfDay < 12){
            greetings = "Good Morning";
        } else if(timeOfDay >= 12 && timeOfDay < 16){
            greetings = "Good Afternoon";
        } else if(timeOfDay >= 16 && timeOfDay < 24){
            greetings = "Good Evening";
        }
        return greetings;
    }
}

