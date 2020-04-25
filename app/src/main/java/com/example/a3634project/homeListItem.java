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
        // ArrayList of pictures to load into Home Fragment
        ArrayList<homeListItem> homeListItem = new ArrayList<>();
        // glass of water image source:
        homeListItem.add(new homeListItem(R.drawable.waterglass, "Add water intake"));
        // vitamins image source: unsplash.com
        homeListItem.add(new homeListItem(R.drawable.vitaminsmain, "Add vitamins intake"));
        // fruits image source: isorepublic.com
        homeListItem.add(new homeListItem(R.drawable.fruitsmain, "Add fruits intake"));
        // food image source: pexels.com
        homeListItem.add(new homeListItem(R.drawable.foodmain, "Add food intake"));
        return homeListItem;
    }
}
