package com.example.a3634project;

import java.util.ArrayList;

public class waterListItem {
    int mWaterImage;
    String mWaterName;

    public waterListItem(int waterImage, String waterName){
        mWaterImage = waterImage;
        mWaterName = waterName;
    }

    public int getmWaterImage() {
        return mWaterImage;
    }

    public String getmWaterName() {
        return mWaterName;
    }

    public static ArrayList<waterListItem> getList(){
        //ArrayList to load into add_water activity
        ArrayList<waterListItem> waterListItems = new ArrayList<>();
        // image source: unsplash.com
        // Scwhendener M 2018, Clear drinking glass filled with water, Unsplash, viewed 26 April 2020, <https://unsplash.com/s/photos/glass-of-water>
        waterListItems.add(new waterListItem(R.drawable.waterglass1, "Glass of water ~250ml"));
        // image source: pxhere.com
        // Bottle of water 2018, Pxhere, viewed 22 April 2020, <https://pxhere.com/en/photo/1541795>
        waterListItems.add(new waterListItem(R.drawable.bottleofwater, "Bottle of water ~ 500ml"));
        return waterListItems;

    }
}
