package com.example.a3634project.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.a3634project.DiaryEntry;

@Database(entities = {DiaryEntry.class}, version = 1)
public abstract class FoodIntakeDatabase extends RoomDatabase {

    private static FoodIntakeDatabase INSTANCE;

    public static FoodIntakeDatabase getDiaryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), FoodIntakeDatabase.class, "diaryDatabase").build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract FoodIntakeDao diaryDao();

}
