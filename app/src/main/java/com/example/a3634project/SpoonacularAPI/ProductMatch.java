package com.example.a3634project.SpoonacularAPI;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductMatch implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("averageRating")
    @Expose
    private Double averageRating;
    @SerializedName("ratingCount")
    @Expose
    private Integer ratingCount;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("link")
    @Expose
    private String link;
    private final static long serialVersionUID = -6065215792760361850L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProductMatch() {
    }

    /**
     *
     * @param score
     * @param price
     * @param imageUrl
     * @param averageRating
     * @param link
     * @param description
     * @param id
     * @param title
     * @param ratingCount
     */
    public ProductMatch(Integer id, String title, String description, String price, String imageUrl, Double averageRating, Integer ratingCount, Double score, String link) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.averageRating = averageRating;
        this.ratingCount = ratingCount;
        this.score = score;
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductMatch withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProductMatch withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductMatch withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ProductMatch withPrice(String price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ProductMatch withImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public ProductMatch withAverageRating(Double averageRating) {
        this.averageRating = averageRating;
        return this;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public ProductMatch withRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
        return this;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public ProductMatch withScore(Double score) {
        this.score = score;
        return this;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ProductMatch withLink(String link) {
        this.link = link;
        return this;
    }

}