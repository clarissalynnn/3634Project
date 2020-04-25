package com.example.a3634project.Database;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;


import com.example.a3634project.Models.User;
import com.example.a3634project.Models.UserIntakeInput;

import java.util.List;

@Dao
public interface FoodIntakeInputDao {

    @Query("SELECT * FROM UserIntakeInput")
    List<UserIntakeInput> getVitamins();

    @Query("SELECT * FROM UserIntakeInput ORDER BY input_timestamp DESC")
    List<UserIntakeInput> getVitaminHist();

    @Insert
    void insert(UserIntakeInput userIntakeInput);


}
