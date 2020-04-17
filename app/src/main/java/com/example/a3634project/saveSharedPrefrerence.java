package com.example.a3634project;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.a3634project.Models.User;
import com.google.gson.Gson;

public class saveSharedPrefrerence {

    static final String PREF_EMAIL="email";
    static final String PREF_USER="user";
    static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }
    public static void setPrefEmail(Context ctx, String email)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_EMAIL, email);
        editor.commit();
    }

    public static void setPrefUser(Context ctx, User user)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        Gson gson = new Gson();
        String json = gson.toJson(user);
        editor.putString(PREF_USER, json);
        editor.commit();
    }

    public static String getPrefEmail(Context ctx)
    {
        return getSharedPreferences(ctx).getString(PREF_EMAIL, "");
    }

    public static String getPrefUser(Context ctx)
    {
        return getSharedPreferences(ctx).getString(PREF_USER,"");

    }
}
