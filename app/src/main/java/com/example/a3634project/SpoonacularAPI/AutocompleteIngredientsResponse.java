package com.example.a3634project.SpoonacularAPI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AutocompleteIngredientsResponse implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("aisle")
    @Expose
    private String aisle;
    @SerializedName("possibleUnits")
    @Expose
    private List<String> possibleUnits = new ArrayList<String>();
    private final static long serialVersionUID = -3786234107464089868L;

    /**
     * No args constructor for use in serialization
     *
     */
    public AutocompleteIngredientsResponse() {
    }

    /**
     *
     * @param image
     * @param name
     * @param possibleUnits
     * @param id
     * @param aisle
     */
    public AutocompleteIngredientsResponse(String name, String image, Integer id, String aisle, List<String> possibleUnits) {
        super();
        this.name = name;
        this.image = image;
        this.id = id;
        this.aisle = aisle;
        this.possibleUnits = possibleUnits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AutocompleteIngredientsResponse withName(String name) {
        this.name = name;
        return this;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public AutocompleteIngredientsResponse withImage(String image) {
        this.image = image;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AutocompleteIngredientsResponse withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public AutocompleteIngredientsResponse withAisle(String aisle) {
        this.aisle = aisle;
        return this;
    }

    public List<String> getPossibleUnits() {
        return possibleUnits;
    }

    public void setPossibleUnits(List<String> possibleUnits) {
        this.possibleUnits = possibleUnits;
    }

    public AutocompleteIngredientsResponse withPossibleUnits(List<String> possibleUnits) {
        this.possibleUnits = possibleUnits;
        return this;
    }

}