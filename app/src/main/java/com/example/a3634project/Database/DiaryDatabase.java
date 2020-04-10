package com.example.a3634project.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.a3634project.DiaryEntry;

@Database(entities = {DiaryEntry.class}, version = 1)
public abstract class DiaryDatabase extends RoomDatabase {

    private static DiaryDatabase INSTANCE;

    public static DiaryDatabase getDiaryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), DiaryDatabase.class, "diaryDatabase").build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract DiaryDao diaryDao();

}
