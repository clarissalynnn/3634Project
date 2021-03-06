package com.example.a3634project.SpoonacularAPI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ingredient implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("unit")
    @Expose
    private String unit;
    @SerializedName("nutrients")
    @Expose
    private List<Nutrient_> nutrients = new ArrayList<Nutrient_>();
    private final static long serialVersionUID = -7011094086666806737L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Ingredient() {
    }

    /**
     *
     * @param amount
     * @param unit
     * @param name
     * @param nutrients
     */
    public Ingredient(String name, Double amount, String unit, List<Nutrient_> nutrients) {
        super();
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.nutrients = nutrients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ingredient withName(String name) {
        this.name = name;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Ingredient withAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Ingredient withUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public List<Nutrient_> getNutrients() {
        return nutrients;
    }

    public void setNutrients(List<Nutrient_> nutrients) {
        this.nutrients = nutrients;
    }

    public Ingredient withNutrients(List<Nutrient_> nutrients) {
        this.nutrients = nutrients;
        return this;
    }

}