package com.example.a3634project;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Maybe;

@Dao
public interface DiaryDao {
    @Query("SELECT * FROM diaryEntry")
    Maybe<List<DiaryEntry>> getAll();

    @Insert
    void insertAll(DiaryEntry... diaryEntries);
}
