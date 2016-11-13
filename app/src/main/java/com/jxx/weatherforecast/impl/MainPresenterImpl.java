package com.jxx.weatherforecast.impl;


import android.util.Log;

import com.google.gson.Gson;
import com.jxx.weatherforecast.model.WeatherInfo;
import com.jxx.weatherforecast.presenter.IMainPresenter;
import com.jxx.weatherforecast.util.HttpCallbackListener;
import com.jxx.weatherforecast.util.HttpUtils;
import com.jxx.weatherforecast.view.IMainView;


/**
 * Created by jxx on 2016/11/8.
 */

public class MainPresenterImpl implements IMainPresenter {

    IMainView mainView;
    WeatherInfo weatherInfo;
    public MainPresenterImpl(IMainView ivew){
        this.mainView = ivew;

    }

    private void getWeatherInformation() {

    }

    //更新Main界面天气信息
    @Override
    public void UpdateWeatherInfo() {
        HttpUtils.HttpGetJson("https://api.heweather.com/x3/weather?cityid=CN101010100&key=77d857413f1845949c1f28207f3319d9"
                , new HttpCallbackListener() {
                    @Override
                    public void onFinish(byte[] bytes) {

                    }

                    @Override
                    public void onFinish(String response) {
                        Gson gson = new Gson();
                        response = response.substring(31, response.length() - 2);
                        weatherInfo = gson.fromJson(response, WeatherInfo.class);
                        Log.d("weather","onfinish");
                        if(weatherInfo!=null){
                            mainView.showNowStatus(weatherInfo.getNow());
                            mainView.showDailyStatus(weatherInfo.getDaily_forecast());
                        }
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
    }


}
