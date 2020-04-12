package com.example.a3634project.SpoonacularAPI;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface APIService {

    @Headers({"x-rapidapi-host: spoonacular-recipe-food-nutrition-v1.p.rapidapi.com",
            "x-rapidapi-key: 84a358909dmshdb113ea9263aa0ep177d19jsnfc068a04319d"
    })
    @GET("/recipes/random")
    Call<RecipeResponse> getRecipe();

    @GET("/food/jokes/random")
    Call<JokeResponse> getFoodJoke();
}
