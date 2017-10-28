package com.example.fire.zhbjdemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by fire on 2017/10/28.
 */

public class PrefUtils {
    private static final String PFCONFIG = "config";

    public static boolean getBoolean(Context context, String key, boolean defaultValue){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PFCONFIG, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key,defaultValue);
    }


    public static void setBoolean(Context context,String key,boolean value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PFCONFIG, Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(key,value).commit();
    }
}
