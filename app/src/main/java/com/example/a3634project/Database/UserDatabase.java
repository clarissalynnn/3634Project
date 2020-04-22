package com.example.a3634project.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.a3634project.Models.User;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao getUserDao();

}


