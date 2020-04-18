package com.example.a3634project;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ingredientsEntry")
public class IngredientsEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "ingredientsEntryTitle")
    private String DiaryEntryTitle;

    @ColumnInfo(name = "diaryText")
    private String DiaryText;

    public IngredientsEntry() {

    }
}
