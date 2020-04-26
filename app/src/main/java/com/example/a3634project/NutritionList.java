package com.example.a3634project;

import android.os.Parcel;

import com.example.a3634project.SpoonacularAPI.Nutrient;
import com.example.a3634project.SpoonacularAPI.Nutrition;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class NutritionList extends ExpandableGroup<NutrientGroups> {

    public NutritionList(String title, List<NutrientGroups> items) {
        super(title, items);
    }

}
