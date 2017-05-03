package com.example.hardware;

import android.app.Application;

import utils.TypefaceUtil;

/**
 * Created by abhishekyadav on 04/05/17.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/ProximaNova.ttf");        //  This FontsOverride comes from the example I posted above
    }
}