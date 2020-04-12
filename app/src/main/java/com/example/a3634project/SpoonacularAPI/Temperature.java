package com.example.a3634project.SpoonacularAPI;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Temperature implements Serializable
{

    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("unit")
    @Expose
    private String unit;
    private final static long serialVersionUID = -6346788604750752280L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Temperature() {
    }

    /**
     *
     * @param number
     * @param unit
     */
    public Temperature(Integer number, String unit) {
        super();
        this.number = number;
        this.unit = unit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Temperature withNumber(Integer number) {
        this.number = number;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Temperature withUnit(String unit) {
        this.unit = unit;
        return this;
    }

}