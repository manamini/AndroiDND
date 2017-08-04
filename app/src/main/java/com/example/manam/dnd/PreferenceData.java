package com.example.manam.dnd;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by manam on 6/5/2017.
 */

public class PreferenceData {

    static SharedPreferences sharedprefs;

    public static void saveData(Context context, String name, String key, String value){
        sharedprefs=context.getSharedPreferences(name, Context.MODE_PRIVATE);
        sharedprefs.edit().putString(key, value).commit();
    }

    public static String loadData(Context context, String name, String key, String defaultValue){
        sharedprefs = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sharedprefs.getString(key, defaultValue);
    }

    public static void saveChecks(Context context, String name, String key, boolean value){
        sharedprefs = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        sharedprefs.edit().putBoolean(key, value).commit();
    }

    public static boolean loadChecks(Context context, String name, String key, boolean defaultValue){
        sharedprefs = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sharedprefs.getBoolean(key, defaultValue);
    }

    public static void saveSpinner(Context context, String name, String key, int value){
        sharedprefs = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        sharedprefs.edit().putInt(key, value).commit();
    }

    public static int loadSpinner(Context context, String name, String key, int defaultValue){
        sharedprefs = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sharedprefs.getInt(key, defaultValue);
    }

}
