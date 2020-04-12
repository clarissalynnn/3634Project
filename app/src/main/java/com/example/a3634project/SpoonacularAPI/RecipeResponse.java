package com.example.a3634project.SpoonacularAPI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecipeResponse implements Serializable
{

    @SerializedName("recipes")
    @Expose
    private List<Recipe> recipes = new ArrayList<Recipe>();
    private final static long serialVersionUID = 1304671972625469152L;

    /**
     * No args constructor for use in serialization
     *
     */
    public RecipeResponse() {
    }

    /**
     *
     * @param recipes
     */
    public RecipeResponse(List<Recipe> recipes) {
        super();
        this.recipes = recipes;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public RecipeResponse withRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
        return this;
    }

}
