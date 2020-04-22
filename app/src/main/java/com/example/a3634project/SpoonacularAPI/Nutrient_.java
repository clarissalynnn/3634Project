package com.example.a3634project.SpoonacularAPI;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nutrient_ implements Serializable
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
    private final static long serialVersionUID = 62936616154057592L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Nutrient_() {
    }

    /**
     *
     * @param amount
     * @param unit
     * @param name
     */
    public Nutrient_(String name, Double amount, String unit) {
        super();
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Nutrient_ withName(String name) {
        this.name = name;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Nutrient_ withAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Nutrient_ withUnit(String unit) {
        this.unit = unit;
        return this;
    }

}
