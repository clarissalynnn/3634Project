package com.example.a3634project.SpoonacularAPI;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JokeResponse implements Serializable
{

    @SerializedName("text")
    @Expose
    private String text;
    private final static long serialVersionUID = -3875900323357376465L;

    /**
     * No args constructor for use in serialization
     *
     */
    public JokeResponse() {
    }

    /**
     *
     * @param text
     */
    public JokeResponse(String text) {
        super();
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public JokeResponse withText(String text) {
        this.text = text;
        return this;
    }

}
