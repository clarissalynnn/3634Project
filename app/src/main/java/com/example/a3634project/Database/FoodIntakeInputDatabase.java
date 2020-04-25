package com.example.a3634project.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.a3634project.Models.UserIntakeInput;

@Database(entities = {UserIntakeInput.class}, version = 1)
public abstract class FoodIntakeInputDatabase extends RoomDatabase {
    public abstract FoodIntakeInputDao getFoodIntakeInputDao();
}
