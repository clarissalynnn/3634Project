package com.example.a3634project.SpoonacularAPI;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface APIService {
    //Pat API header - switch between headers if request limit is reached
    @Headers({"x-rapidapi-host: spoonacular-recipe-food-nutrition-v1.p.rapidapi.com",
            "x-rapidapi-key: 84a358909dmshdb113ea9263aa0ep177d19jsnfc068a04319d"
    })


    @GET("/recipes/random")
    Call<RecipeResponse> getRecipe();

    @GET("/food/jokes/random")
    Call<JokeResponse> getFoodJoke();

    @Headers({"x-rapidapi-host: spoonacular-recipe-food-nutrition-v1.p.rapidapi.com",
            "x-rapidapi-key: dc4cf08b30mshec08ef4d4bf3400p1ebf39jsnc6890c2d1747"
    })
    @GET("/food/ingredients/autocomplete")
    Call<AutocompleteIngredientsResponse> getAutocompleteIngredientsSearch(
            @Query("name") String name,
            @Query("number") int number,
            @Query("boolean") boolean boo

    );

    @Headers({"x-rapidapi-host: spoonacular-recipe-food-nutrition-v1.p.rapidapi.com",
            "x-rapidapi-key: dc4cf08b30mshec08ef4d4bf3400p1ebf39jsnc6890c2d1747"
    })
    @GET("/food/ingredients/{id}/information")
    Call<IngredientsResponse> getFoodInformation(
            @Query("id") int id,
            @Query("amount") int amount,
            @Query("measurement") String measurement
            );


}
