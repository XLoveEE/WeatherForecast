package com.jxx.weatherforecast.activity;

import android.os.Bundle;
import android.util.Log;

import com.jxx.weatherforecast.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String key = getWeatherKey();
        Log.d("WeatherAPI",key);


    }
}
