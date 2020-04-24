package com.example.a3634project;

import java.util.ArrayList;

public class homeListItem {
    int mHomeImages;
    String mHomeNames;

    public homeListItem(int homeImages, String homeNames){
    mHomeImages = homeImages;
    mHomeNames = homeNames;
    }

    public int getmHomeImages() {
        return mHomeImages;
    }

    public String getmHomeNames() {
        return mHomeNames;
    }

    public static ArrayList<homeListItem> getList(){
        ArrayList<homeListItem> homeListItem = new ArrayList<>();
        homeListItem.add(new homeListItem(R.drawable.waterglass, "Add water intake"));
        homeListItem.add(new homeListItem(R.drawable.vitaminsmain, "Add vitamins intake"));
        homeListItem.add(new homeListItem(R.drawable.fruitsmain, "Add fruits intake"));
        homeListItem.add(new homeListItem(R.drawable.foodmain, "Add food intake"));
        return homeListItem;
    }
}
