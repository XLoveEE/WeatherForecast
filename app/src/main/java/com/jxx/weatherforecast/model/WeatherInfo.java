package com.jxx.weatherforecast.model;

import java.util.List;

/**
 * Created by jxx on 2016/11/2.
 */

public class WeatherInfo {
    private  AQI aqi;
    private  BasicWeather basic;
    private  List<DailyForecast> daily_forecast;
    private  List<HourlyForecast> hourly_forecast;
    private  NowWeather now;
    private  String status;
    private  Suggestion suggestion;

    public AQI getAqi() {
        return aqi;
    }

    public void setAqi(AQI aqi) {
        this.aqi = aqi;
    }

    public BasicWeather getBasic() {
        return basic;
    }

    public void setBasic(BasicWeather basic) {
        this.basic = basic;
    }

    public List<DailyForecast> getDaily_forecast() {
        return daily_forecast;
    }

    public void setDaily_forecast(List<DailyForecast> daily_forecast) {
        this.daily_forecast = daily_forecast;
    }

    public List<HourlyForecast> getHourly_forecast() {
        return hourly_forecast;
    }

    public void setHourly_forecast(List<HourlyForecast> hourly_forecast) {
        this.hourly_forecast = hourly_forecast;
    }

    public NowWeather getNow() {
        return now;
    }

    public void setNow(NowWeather now) {
        this.now = now;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Suggestion getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Suggestion suggestion) {
        this.suggestion = suggestion;
    }
}
