package com.example.a3634project.SpoonacularAPI;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeightPerServing implements Serializable
{

    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("unit")
    @Expose
    private String unit;
    private final static long serialVersionUID = 343178948422783790L;

    /**
     * No args constructor for use in serialization
     *
     */
    public WeightPerServing() {
    }

    /**
     *
     * @param amount
     * @param unit
     */
    public WeightPerServing(Integer amount, String unit) {
        super();
        this.amount = amount;
        this.unit = unit;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public WeightPerServing withAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public WeightPerServing withUnit(String unit) {
        this.unit = unit;
        return this;
    }

}