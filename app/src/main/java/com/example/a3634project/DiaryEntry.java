package com.example.a3634project;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "diaryEntry")
public class DiaryEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "diaryEntryTitle")
    private String DiaryEntryTitle;

    @ColumnInfo(name = "diaryText")
    private String DiaryText;

    public DiaryEntry() {

    }

    public DiaryEntry(int id, String title, String note) {
        this.id = id;
        this.DiaryEntryTitle = title;
        this.DiaryText = note;
    }

    public DiaryEntry(String title, String note) {
        this.DiaryEntryTitle = title;
        this.DiaryText = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiaryEntryTitle() {
        return DiaryEntryTitle;
    }

    public void setDiaryEntryTitle(String title) {
        this.DiaryEntryTitle = title;
    }

    public String getDiaryText() {
        return DiaryText;
    }

    public void setDiaryText(String note) {
        this.DiaryText = note;
    }
}