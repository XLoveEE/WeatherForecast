package com.jxx.weatherforecast.activity;

import android.os.Bundle;
import android.util.Log;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.common.LogRedirector;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.jxx.weatherforecast.R;
import com.jxx.weatherforecast.db.WeatherDB;
import com.jxx.weatherforecast.model.CityInfo;
import com.jxx.weatherforecast.model.CityInfoArray;
import com.jxx.weatherforecast.util.HttpCallbackListener;
import com.jxx.weatherforecast.util.HttpUtils;
import com.orhanobut.logger.Logger;

import okhttp3.OkHttpClient;

public class NavActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        Stetho.initializeWithDefaults(this);
        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
        InitInfo();
    }

    private void InitInfo(){
        //加载城市信息
        HttpUtils.HttpGetJson("https://api.heweather.com/x3/citylist?search=allchina&key=77d857413f1845949c1f28207f3319d9", new HttpCallbackListener() {
            @Override
            public void onFinish(byte[] bytes) {
            }

            @Override
            public void onFinish(String response) {
                Logger.json(response);
                Gson gson = new Gson();
                CityInfoArray cityInfoArray = gson.fromJson(response,CityInfoArray.class);
                for(CityInfo city : cityInfoArray.getCityinfo()){
                    WeatherDB.getInstance(NavActivity.this).saveCityInformation(city);
                }
            }

            @Override
            public void onError(Exception e) {
                Logger.d(e.getMessage());
            }
        });

        //预加载天气信息到数据库
    }

}
