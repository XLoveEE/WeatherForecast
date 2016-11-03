package com.jxx.weatherforecast.view;

import com.jxx.weatherforecast.model.DailyForecast;
import com.jxx.weatherforecast.model.HourlyForecast;
import com.jxx.weatherforecast.model.NowWeather;

/**
 * Created by Jxx on 2016/11/3.
 */

public interface IMainView {

    void showNowStatus(NowWeather data);
    void showDailyStatus(DailyForecast data);
    void showHourlyStatus(HourlyForecast data);

}
