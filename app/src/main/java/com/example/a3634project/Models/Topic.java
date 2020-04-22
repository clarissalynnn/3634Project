package com.example.a3634project.Models;

import com.example.a3634project.R;

import java.util.ArrayList;

public class Topic {

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
        topic.add(new Topic(R.drawable.recipe,"Recipes", "Explore 1,000+ recipes across different cuisines"));
        topic.add(new Topic(R.drawable.ingredient,"Ingredients", "Explore nutrition facts of variety of ingredients"));
        topic.add(new Topic(R.drawable.nutrition, "Nutrition Tips", "Explore nutrition tips for healthy eating"));
        topic.add(new Topic(R.drawable.diet, "Healthy Diet", "Explore different types of healthy diet"));
        return topic;
    }
}
