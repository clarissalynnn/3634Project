package com.example.a3634project;

public class NutrientData {

    private String name;
    private String percentOfDailyNeeds;
    private boolean isExpanded;

    public NutrientData(String name, String percentOfDailyNeeds) {
        this.name = name;
        this.percentOfDailyNeeds = percentOfDailyNeeds;
        isExpanded = false;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPercentOfDailyNeeds() {
        return percentOfDailyNeeds;
    }

    public void setPercentOfDailyNeeds(String percentOfDailyNeeds) {
        this.percentOfDailyNeeds = percentOfDailyNeeds;
    }

    @Override
    public String toString(){
        return name + " " + percentOfDailyNeeds;
    }
}
