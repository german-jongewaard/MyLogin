package dev.com.jongewaard.mylogin.activities;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import dev.com.jongewaard.mylogin.R;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //accedo a los mismos valores guardados en modo privado
        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

    }

    //1er paso Inflar el menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //aqí inflo el menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //2do paso switch con el item seleccionado
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.menu_logout:
                logOut();
                return true;

            case R.id.menu_forgetlogout:
                removeSharedPreferences();
                logOut();
                return true;

            default:

                return super.onOptionsItemSelected(item);

        }
    }

    //desde el MainActivity vamos a ir al LoginActivity
    private void logOut(){

        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }

    //Borrado de todas las preferencias
    private void removeSharedPreferences() {

        prefs.edit().clear().apply();

    }
}
