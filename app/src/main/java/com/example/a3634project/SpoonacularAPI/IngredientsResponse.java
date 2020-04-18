package com.example.a3634project.SpoonacularAPI;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IngredientsResponse implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("aisle")
    @Expose
    private String aisle;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("unit")
    @Expose
    private String unit;
    @SerializedName("nutrition")
    @Expose
    private Nutrition nutrition;
    private final static long serialVersionUID = 5740814057504797866L;

    /**
     * No args constructor for use in serialization
     *
     */
    public IngredientsResponse() {
    }

    /**
     *
     * @param image
     * @param amount
     * @param unit
     * @param nutrition
     * @param name
     * @param id
     * @param aisle
     */
    public IngredientsResponse(Integer id, String name, String aisle, String image, Double amount, String unit, Nutrition nutrition) {
        super();
        this.id = id;
        this.name = name;
        this.aisle = aisle;
        this.image = image;
        this.amount = amount;
        this.unit = unit;
        this.nutrition = nutrition;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public IngredientsResponse withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IngredientsResponse withName(String name) {
        this.name = name;
        return this;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public IngredientsResponse withAisle(String aisle) {
        this.aisle = aisle;
        return this;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public IngredientsResponse withImage(String image) {
        this.image = image;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public IngredientsResponse withAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public IngredientsResponse withUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public Nutrition getNutrition() {
        return nutrition;
    }

    public void setNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
    }

    public IngredientsResponse withNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
        return this;
    }

}