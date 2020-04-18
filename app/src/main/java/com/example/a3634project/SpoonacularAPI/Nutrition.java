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
    @SerializedName("caloricBreakdown")
    @Expose
    private CaloricBreakdown caloricBreakdown;
    private final static long serialVersionUID = -5123728363369645921L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Nutrition() {
    }

    /**
     *
     * @param caloricBreakdown
     * @param nutrients
     */
    public Nutrition(List<Nutrient> nutrients, CaloricBreakdown caloricBreakdown) {
        super();
        this.nutrients = nutrients;
        this.caloricBreakdown = caloricBreakdown;
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

}
