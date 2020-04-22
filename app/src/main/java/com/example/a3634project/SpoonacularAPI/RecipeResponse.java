package com.example.a3634project.SpoonacularAPI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecipeResponse implements Serializable
{

    @SerializedName("results")
    @Expose
    private List<Recipe> recipes = new ArrayList<Recipe>();
    @SerializedName("baseUri")
    @Expose
    private String baseUri;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;
    @SerializedName("processingTimeMs")
    @Expose
    private Integer processingTimeMs;
    @SerializedName("expires")
    @Expose
    private Double expires;
    @SerializedName("isStale")
    @Expose
    private Boolean isStale;
    private final static long serialVersionUID = -3922612309438874757L;

    /**
     * No args constructor for use in serialization
     *
     */
    public RecipeResponse() {
    }

    /**
     *
     * @param number
     * @param totalResults
     * @param expires
     * @param offset
     * @param processingTimeMs
     * @param baseUri
     * @param isStale
     * @param recipes
     */
    public RecipeResponse(List<Recipe> recipes, String baseUri, Integer offset, Integer number, Integer totalResults, Integer processingTimeMs, Double expires, Boolean isStale) {
        super();
        this.recipes = recipes;
        this.baseUri = baseUri;
        this.offset = offset;
        this.number = number;
        this.totalResults = totalResults;
        this.processingTimeMs = processingTimeMs;
        this.expires = expires;
        this.isStale = isStale;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public RecipeResponse withResults(List<Recipe> recipes) {
        this.recipes = recipes;
        return this;
    }

    public String getBaseUri() {
        return baseUri;
    }

    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    public RecipeResponse withBaseUri(String baseUri) {
        this.baseUri = baseUri;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public RecipeResponse withOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public RecipeResponse withNumber(Integer number) {
        this.number = number;
        return this;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public RecipeResponse withTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
        return this;
    }

    public Integer getProcessingTimeMs() {
        return processingTimeMs;
    }

    public void setProcessingTimeMs(Integer processingTimeMs) {
        this.processingTimeMs = processingTimeMs;
    }

    public RecipeResponse withProcessingTimeMs(Integer processingTimeMs) {
        this.processingTimeMs = processingTimeMs;
        return this;
    }

    public Double getExpires() {
        return expires;
    }

    public void setExpires(Double expires) {
        this.expires = expires;
    }

    public RecipeResponse withExpires(Double expires) {
        this.expires = expires;
        return this;
    }

    public Boolean getIsStale() {
        return isStale;
    }

    public void setIsStale(Boolean isStale) {
        this.isStale = isStale;
    }

    public RecipeResponse withIsStale(Boolean isStale) {
        this.isStale = isStale;
        return this;
    }

}
