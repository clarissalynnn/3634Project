package com.example.a3634project.SpoonacularAPI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Step implements Serializable
{

    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("step")
    @Expose
    private String step;
    @SerializedName("ingredients")
    @Expose
    private List<Object> ingredients = new ArrayList<Object>();
    @SerializedName("equipment")
    @Expose
    private List<Equipment> equipment = new ArrayList<Equipment>();
    private final static long serialVersionUID = 3656893927037252015L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Step() {
    }

    /**
     *
     * @param number
     * @param ingredients
     * @param equipment
     * @param step
     */
    public Step(Integer number, String step, List<Object> ingredients, List<Equipment> equipment) {
        super();
        this.number = number;
        this.step = step;
        this.ingredients = ingredients;
        this.equipment = equipment;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Step withNumber(Integer number) {
        this.number = number;
        return this;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public Step withStep(String step) {
        this.step = step;
        return this;
    }

    public List<Object> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Object> ingredients) {
        this.ingredients = ingredients;
    }

    public Step withIngredients(List<Object> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public Step withEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
        return this;
    }

}