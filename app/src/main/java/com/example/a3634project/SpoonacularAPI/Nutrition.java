package com.example.a3634project.SpoonacularAPI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nutrition implements Serializable
{

    @SerializedName("nutrients")
    @Expose
    private List<Nutrient> nutrients = new ArrayList<Nutrient>();
    @SerializedName("ingredients")
    @Expose
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();
    @SerializedName("caloricBreakdown")
    @Expose
    private CaloricBreakdown caloricBreakdown;
    @SerializedName("weightPerServing")
    @Expose
    private WeightPerServing weightPerServing;
    private final static long serialVersionUID = 2351920673504570002L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Nutrition() {
    }

    /**
     *
     * @param caloricBreakdown
     * @param weightPerServing
     * @param ingredients
     * @param nutrients
     */
    public Nutrition(List<Nutrient> nutrients, List<Ingredient> ingredients, CaloricBreakdown caloricBreakdown, WeightPerServing weightPerServing) {
        super();
        this.nutrients = nutrients;
        this.ingredients = ingredients;
        this.caloricBreakdown = caloricBreakdown;
        this.weightPerServing = weightPerServing;
    }

    public List<Nutrient> getNutrients() {
        return nutrients;
    }

    public void setNutrients(List<Nutrient> nutrients) {
        this.nutrients = nutrients;
    }

    public Nutrition withNutrients(List<Nutrient> nutrients) {
        this.nutrients = nutrients;
        return this;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Nutrition withIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public CaloricBreakdown getCaloricBreakdown() {
        return caloricBreakdown;
    }

    public void setCaloricBreakdown(CaloricBreakdown caloricBreakdown) {
        this.caloricBreakdown = caloricBreakdown;
    }

    public Nutrition withCaloricBreakdown(CaloricBreakdown caloricBreakdown) {
        this.caloricBreakdown = caloricBreakdown;
        return this;
    }

    public WeightPerServing getWeightPerServing() {
        return weightPerServing;
    }

    public void setWeightPerServing(WeightPerServing weightPerServing) {
        this.weightPerServing = weightPerServing;
    }

    public Nutrition withWeightPerServing(WeightPerServing weightPerServing) {
        this.weightPerServing = weightPerServing;
        return this;
    }

}