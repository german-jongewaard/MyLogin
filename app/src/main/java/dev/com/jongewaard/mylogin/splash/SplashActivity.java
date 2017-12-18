package dev.com.jongewaard.mylogin.splash;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import dev.com.jongewaard.mylogin.activities.LoginActivity;
import dev.com.jongewaard.mylogin.utils.Util;

/**
 * Created by german on 18-12-17.
 */

public class SplashActivity extends AppCompatActivity {

    private SharedPreferences prefs;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //aqui ya tengo la instancia
        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        Intent intentLogin = new Intent(this, LoginActivity.class);
        Intent intentMain = new Intent(this, LoginActivity.class);

        //si no esta vacio el email y no esta vacio el password
        if(!TextUtils.isEmpty(Util.getUserMailPrefs(prefs)) && !TextUtils.isEmpty(Util.getUserPassPrefs(prefs))){

            startActivity(intentMain);
        }else {
            startActivity(intentLogin);
        }
        finish();//mata la instnacia de este activity


    }


}
