package com.example.catlistapp.app;

import android.app.Application;
import android.content.Context;

public class App extends Application {

private static App app;

    public static Context getAppContext() {
        return app.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
