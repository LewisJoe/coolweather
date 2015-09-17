package com.lewis.coolweather.model;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 15-9-17.
 * 用于获取全局Context
 */
public class MyApplication extends Application{
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
