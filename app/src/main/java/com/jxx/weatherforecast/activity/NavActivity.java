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

public class NavActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
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
                Log.d("http",response);
                Gson gson = new Gson();
                CityInfoArray cityInfoArray = gson.fromJson(response,CityInfoArray.class);
                for(CityInfo city : cityInfoArray.getCityinfo()){
                    WeatherDB.getInstance(NavActivity.this).saveCityInformation(city);
                }
            }

            @Override
            public void onError(Exception e) {
                Log.d("Debug",e.getMessage());
            }
        });

        //预加载天气信息到数据库
    }

}
