package com.example.a3634project.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.a3634project.Models.VitaminIntake;

@Database(entities = {VitaminIntake.class}, version = 1)
public abstract class VitaminIntakeDatabase extends RoomDatabase {
    public abstract VitaminIntakeDao getFoodIntakeInputDao();
}
