package dev.com.jongewaard.mylogin;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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

                return true;

            case R.id.menu_forgetlogout:

                return true;

            default:

                return super.onOptionsItemSelected(item);

        }

    }
}
