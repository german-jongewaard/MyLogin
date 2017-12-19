package dev.com.jongewaard.mylogin.app;

import android.app.Application;
import android.os.SystemClock;

/**
 * Created by german on 18-12-17.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {

        super.onCreate();

        // Este es solo para poder ver el Splash Screen durante 3 segundos
        SystemClock.sleep(3000);
    }
}
