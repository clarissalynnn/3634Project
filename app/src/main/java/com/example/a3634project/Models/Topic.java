package com.example.a3634project.Models;

import com.example.a3634project.R;

import java.util.ArrayList;

public class Topic {

    //this is just a sample Topic class, need API to get actual data!
    private int image;
    private String name;
    private String description;

    public Topic(int image, String name, String description) {
        this.image = image;
        this.name = name;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static ArrayList<Topic> getTopics() {
        ArrayList<Topic> topic = new ArrayList<>();
        topic.add(new Topic(R.drawable.recipe,"Recipes", "some description for recipe"));
        topic.add(new Topic(R.drawable.ingredient,"Ingredients", "some description for ingredient"));
        //topic.add(new Topic("Articles"));
        //topic.add(new Topic("Food Trivia"));
        return topic;
    }
}
