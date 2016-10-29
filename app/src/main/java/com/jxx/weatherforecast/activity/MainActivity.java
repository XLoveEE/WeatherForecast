package com.jxx.weatherforecast.activity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.jxx.weatherforecast.R;
import com.jxx.weatherforecast.db.WeatherDB;
import com.jxx.weatherforecast.model.CityInfo;
import com.jxx.weatherforecast.model.CityInfoArray;
import com.jxx.weatherforecast.util.HttpCallbackListener;
import com.jxx.weatherforecast.util.HttpUtils;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
