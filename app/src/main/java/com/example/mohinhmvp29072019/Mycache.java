package com.example.mohinhmvp29072019;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Objects;

public class Mycache {
    private static SharedPreferences sharedPreferences = null;
    private static SharedPreferences.Editor editor = null;
    private static Mycache mycache = null;

    private Mycache(Context context){
        sharedPreferences = context.getSharedPreferences("CacheApp", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public static Mycache getInstanceCache(Context context){
        if (sharedPreferences == null){
           mycache = new Mycache(context);
        }
        return mycache;
    }

    public <T> void saveValue(String key, T objects){
        if (objects instanceof String){
            editor.putString(key,(String) objects);
        }
        if (objects instanceof Boolean){
            editor.putBoolean(key,(Boolean) objects);
        }

        editor.commit();
    }

}
