package com.jxx.weatherforecast.presenter;

import com.jxx.weatherforecast.model.WeatherInfo;

/**
 * Created by Jxx on 2016/11/3.
 */

public interface IMainPresenter {
    //获得天气信息
    WeatherInfo getWeatherInformation();
    void UpdateWeatherInfo(WeatherInfo data);;
}
