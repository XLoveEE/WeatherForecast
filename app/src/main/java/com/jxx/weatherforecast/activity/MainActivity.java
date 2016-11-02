package com.jxx.weatherforecast.activity;

import android.os.Bundle;

import com.google.gson.Gson;
import com.jxx.weatherforecast.R;

import com.jxx.weatherforecast.model.WeatherInfo;
import com.jxx.weatherforecast.util.HttpCallbackListener;
import com.jxx.weatherforecast.util.HttpUtils;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpUtils.HttpGetJson("https://api.heweather.com/x3/weather?cityid=CN101010100&key=77d857413f1845949c1f28207f3319d9"
                , new HttpCallbackListener() {
                    @Override
                    public void onFinish(byte[] bytes) {

                    }

                    @Override
                    public void onFinish(String response) {
                        Gson gson = new Gson();
                        response = response.substring(31,response.length()-2);
                        WeatherInfo weatherInfo = gson.fromJson(response,WeatherInfo.class);
                        return;
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
    }
}
