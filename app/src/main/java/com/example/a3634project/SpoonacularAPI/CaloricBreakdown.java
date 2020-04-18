package com.example.a3634project.SpoonacularAPI;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CaloricBreakdown implements Serializable
{

    @SerializedName("percentProtein")
    @Expose
    private Double percentProtein;
    @SerializedName("percentFat")
    @Expose
    private Double percentFat;
    @SerializedName("percentCarbs")
    @Expose
    private Double percentCarbs;
    private final static long serialVersionUID = 3817502935730196572L;

    /**
     * No args constructor for use in serialization
     *
     */
    public CaloricBreakdown() {
    }

    /**
     *
     * @param percentCarbs
     * @param percentProtein
     * @param percentFat
     */
    public CaloricBreakdown(Double percentProtein, Double percentFat, Double percentCarbs) {
        super();
        this.percentProtein = percentProtein;
        this.percentFat = percentFat;
        this.percentCarbs = percentCarbs;
    }

    public Double getPercentProtein() {
        return percentProtein;
    }

    public void setPercentProtein(Double percentProtein) {
        this.percentProtein = percentProtein;
    }

    public CaloricBreakdown withPercentProtein(Double percentProtein) {
        this.percentProtein = percentProtein;
        return this;
    }

    public Double getPercentFat() {
        return percentFat;
    }

    public void setPercentFat(Double percentFat) {
        this.percentFat = percentFat;
    }

    public CaloricBreakdown withPercentFat(Double percentFat) {
        this.percentFat = percentFat;
        return this;
    }

    public Double getPercentCarbs() {
        return percentCarbs;
    }

    public void setPercentCarbs(Double percentCarbs) {
        this.percentCarbs = percentCarbs;
    }

    public CaloricBreakdown withPercentCarbs(Double percentCarbs) {
        this.percentCarbs = percentCarbs;
        return this;
    }

}