package com.example.a3634project.SpoonacularAPI;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface APIService {
    //Pat API header - switch between headers if request limit is reached
   /* @Headers({"x-rapidapi-host: spoonacular-recipe-food-nutrition-v1.p.rapidapi.com",
            "x-rapidapi-key: 84a358909dmshdb113ea9263aa0ep177d19jsnfc068a04319d"
    })*/
   //Sam api header 1
    @Headers({"x-rapidapi-host: spoonacular-recipe-food-nutrition-v1.p.rapidapi.com",
           "x-rapidapi-key: dc4cf08b30mshec08ef4d4bf3400p1ebf39jsnc6890c2d1747"
   })
    @GET("/recipes/random")
    Call<RecipeResponse> getRecipe();

    @GET("/food/jokes/random")
    Call<JokeResponse> getFoodJoke();
}
