package com.example.a3634project.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.a3634project.DiaryEntry;

import java.util.List;

import io.reactivex.Maybe;

@Dao
public interface FoodIntakeDao {
    @Query("SELECT * FROM diaryEntry")
    Maybe<List<DiaryEntry>> getAll();

    @Insert
    void insertAll(DiaryEntry... diaryEntries);
}
