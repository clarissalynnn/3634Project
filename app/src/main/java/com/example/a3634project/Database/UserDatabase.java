package com.example.a3634project.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.a3634project.Models.User;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao getUserDao();

    // acquire instance of database using Room.databaseBuilder()
    /*
    private static UserDatabase INSTANCE;
    public static UserDatabase getUserDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "userDatabase").build();
        }
        return INSTANCE;

     */

}


