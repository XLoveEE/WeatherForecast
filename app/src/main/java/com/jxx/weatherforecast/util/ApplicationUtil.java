package com.jxx.weatherforecast.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jxx on 2016/11/4.
 */

public class ApplicationUtil extends Application{
    private static Context mcontext;

    @Override
    public void onCreate() {
        super.onCreate();
        mcontext = getApplicationContext();
    }

    public  static  Context getContext(){
        return  mcontext;
    }

}
