package com.jxx.weatherforecast.activity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.jxx.weatherforecast.R;
import com.jxx.weatherforecast.model.CityInfoArray;
import com.jxx.weatherforecast.util.HttpCallbackListener;
import com.jxx.weatherforecast.util.HttpUtils;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //String key = getWeatherKey();
        //Log.d("WeatherAPI",key);

        HttpUtils.HttpGet("https://api.heweather.com/x3/citylist?search=allchina&key=77d857413f1845949c1f28207f3319d9", new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                Log.d("http",response);
                Gson gson = new Gson();
                CityInfoArray cityInfoArray = gson.fromJson(response,CityInfoArray.class);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
