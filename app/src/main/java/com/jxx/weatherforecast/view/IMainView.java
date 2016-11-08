package com.jxx.weatherforecast.view;

import com.jxx.weatherforecast.model.AQI;
import com.jxx.weatherforecast.model.DailyForecast;
import com.jxx.weatherforecast.model.HourlyForecast;
import com.jxx.weatherforecast.model.NowWeather;

import java.util.List;

/**
 * Created by Jxx on 2016/11/3.
 */

public interface IMainView {

    void showNowStatus(NowWeather data);
    void showDailyStatus(List<DailyForecast> data);
    void showHourlyStatus(HourlyForecast data);
    void showAqiStatus(AQI data);
}
