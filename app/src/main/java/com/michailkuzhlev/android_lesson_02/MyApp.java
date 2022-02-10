package com.michailkuzhlev.android_lesson_02;

import android.app.Application;

public class MyApp extends Application {
    public static int currentTheme=R.style.Theme_Android_Origin;

    @Override
    public void onCreate(){
        super.onCreate();
    }
}
