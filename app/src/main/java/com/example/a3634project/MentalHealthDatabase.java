package com.example.a3634project;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class MentalHealthDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}