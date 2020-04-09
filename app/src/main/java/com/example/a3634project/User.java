package com.example.a3634project;

import android.graphics.Bitmap;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
class User {
    @PrimaryKey
    public int uid;

    public String first_name;
    public String last_name;
    public String userEmail;

    @Ignore
    Bitmap picture;
}