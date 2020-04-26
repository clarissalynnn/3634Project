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
        // glass of water image source: unsplash.com
        // Scwhendener M 2018, Clear drinking glass filled with water, Unsplash, viewed 26 April 2020, <https://unsplash.com/s/photos/glass-of-water>
        homeListItem.add(new homeListItem(R.drawable.waterglass1, "Add water intake"));
        // vitamins image source: unsplash.com
        // Blackwell M 2019, Brown gel close-up photography, Unsplash, viewed 22 April 2020, <https://unsplash.com/photos/przZDqzZKpk>
        homeListItem.add(new homeListItem(R.drawable.vitaminsmain, "Add vitamins intake"));
        // fruits image source: isorepublic.com
        // Lark B n.d, Fruit background, Isorepublic, viewed 22 April 2020, <https://isorepublic.com/photo/fruit-background/>
        homeListItem.add(new homeListItem(R.drawable.fruitsmain, "Add fruits intake"));
        // food image source: pexels.com
        // Olsson E 2018, Assorted salads on bowls, Pexels, viewed 22 April 2020,<https://www.pexels.com/photo/assorted-salads-on-bowls-1640773/>
        homeListItem.add(new homeListItem(R.drawable.foodmain, "Add food intake"));
        return homeListItem;
    }
}
