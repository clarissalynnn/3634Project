package com.example.a3634project.SpoonacularAPI;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Equipment implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("temperature")
    @Expose
    private Temperature temperature;
    private final static long serialVersionUID = 8523672130109610992L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Equipment() {
    }

    /**
     *
     * @param image
     * @param name
     * @param temperature
     * @param id
     */
    public Equipment(Integer id, String name, String image, Temperature temperature) {
        super();
        this.id = id;
        this.name = name;
        this.image = image;
        this.temperature = temperature;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Equipment withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Equipment withName(String name) {
        this.name = name;
        return this;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Equipment withImage(String image) {
        this.image = image;
        return this;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Equipment withTemperature(Temperature temperature) {
        this.temperature = temperature;
        return this;
    }

}