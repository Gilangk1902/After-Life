package com.afterlife;

import android.app.Application;

import com.afterlife.DataClass.DataBase;

public class MyApp extends Application {
    public MyApp(){
        DataBase.DataInit();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
