package dev.com.jongewaard.mylogin;

import android.app.Application;
import android.os.SystemClock;

/**
 * Created by german on 18-12-17.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SystemClock.sleep(3000);
    }
}
