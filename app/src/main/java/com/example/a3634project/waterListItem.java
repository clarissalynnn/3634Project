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
        ArrayList<waterListItem> waterListItems = new ArrayList<>();

        waterListItems.add(new waterListItem(R.drawable.waterglass, "Glass of water ~250ml"));
        waterListItems.add(new waterListItem(R.drawable.bottleofwater, "Bottle of water ~ 500ml"));
        return waterListItems;

    }
}
