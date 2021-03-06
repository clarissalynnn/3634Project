package com.example.a3634project.Models;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.text.SimpleDateFormat;
import java.util.List;

@Entity
public class VitaminIntake {

    @PrimaryKey(autoGenerate = true)
    @NonNull
     public int uid;
     public String vitamin_names;
    public int userId;
    public  String input_timestamp;

    public VitaminIntake(String vitamin_names, int userId , String input_timestamp){
        this.vitamin_names = vitamin_names;
        this.userId = userId;
        this.input_timestamp = input_timestamp;

    };

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getVitamin_names() {
        return vitamin_names;
    }

    public void setVitamin_names(String vitamin_names) {
        this.vitamin_names = vitamin_names;
    }

    public String getInput_timestamp() {
        return input_timestamp;
    }

    public void setInput_timestamp(String input_timestamp) {
        this.input_timestamp = input_timestamp;
    }
}




