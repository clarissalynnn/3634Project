package com.example.a3634project.Models;

import java.util.ArrayList;

public class Topic {

    //this is just a sample Topic class, need API to get actual data!
    private String name;

    public Topic(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ArrayList<Topic> getTopics() {
        ArrayList<Topic> topic = new ArrayList<>();
        topic.add(new Topic("Success and Happiness"));
        topic.add(new Topic("Motivation and Change"));
        topic.add(new Topic("Wisdom and Truth"));
        topic.add(new Topic("Life and People"));
        topic.add(new Topic("topic 5"));
        topic.add(new Topic("topic 6"));
        topic.add(new Topic("topic 7"));
        topic.add(new Topic("topic 8"));
        topic.add(new Topic("topic 9"));
        topic.add(new Topic("topic 10"));
        topic.add(new Topic("topic 11"));
        topic.add(new Topic("topic 12"));
        return topic;
    }
}
