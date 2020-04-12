package com.example.a3634project.SpoonacularAPI;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Us implements Serializable
{

    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("unitShort")
    @Expose
    private String unitShort;
    @SerializedName("unitLong")
    @Expose
    private String unitLong;
    private final static long serialVersionUID = 6135676198818372924L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Us() {
    }

    /**
     *
     * @param amount
     * @param unitShort
     * @param unitLong
     */
    public Us(Double amount, String unitShort, String unitLong) {
        super();
        this.amount = amount;
        this.unitShort = unitShort;
        this.unitLong = unitLong;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Us withAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public String getUnitShort() {
        return unitShort;
    }

    public void setUnitShort(String unitShort) {
        this.unitShort = unitShort;
    }

    public Us withUnitShort(String unitShort) {
        this.unitShort = unitShort;
        return this;
    }

    public String getUnitLong() {
        return unitLong;
    }

    public void setUnitLong(String unitLong) {
        this.unitLong = unitLong;
    }

    public Us withUnitLong(String unitLong) {
        this.unitLong = unitLong;
        return this;
    }

}
