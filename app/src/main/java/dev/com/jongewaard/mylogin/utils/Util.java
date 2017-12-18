package dev.com.jongewaard.mylogin.utils;

import android.content.SharedPreferences;

/**
 * Created by german on 18-12-17.
 */

public class Util {



    //obtengo el email
    public static String getUserMailPrefs(SharedPreferences preferences){

        return preferences.getString("email", "");

    }

    //obtengo el password
    public static String getUserPassPrefs(SharedPreferences preferences){

        return preferences.getString("pass", "");

    }
}
