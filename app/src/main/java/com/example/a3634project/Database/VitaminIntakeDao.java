package com.example.a3634project.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.a3634project.Models.VitaminIntake;

import java.util.List;

@Dao
public interface VitaminIntakeDao {

    @Query("SELECT * FROM VitaminIntake")
    List<VitaminIntake> getVitamins();

    @Query("SELECT * FROM VitaminIntake ORDER BY input_timestamp DESC")
    List<VitaminIntake> getVitaminHist();

    @Insert
    void insert(VitaminIntake vitaminIntake);

    @Delete
    void delete(VitaminIntake vitaminIntake);

    @Update
    void update(VitaminIntake vitaminIntake);


}
