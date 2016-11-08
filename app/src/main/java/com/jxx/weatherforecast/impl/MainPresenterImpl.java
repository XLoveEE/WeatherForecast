package com.jxx.weatherforecast.impl;

import com.jxx.weatherforecast.model.WeatherInfo;
import com.jxx.weatherforecast.presenter.IMainPresenter;
import com.jxx.weatherforecast.view.IMainView;


/**
 * Created by jxx on 2016/11/8.
 */

public class MainPresenterImpl implements IMainPresenter {

    IMainView mainView;

    public MainPresenterImpl(IMainView ivew){
        this.mainView = ivew;
    }

    @Override
    public WeatherInfo getWeatherInformation() {
        return null;
    }

    //更新Main界面天气信息
    @Override
    public void UpdateWeatherInfo(WeatherInfo data) {
        mainView.showNowStatus(data.getNow());
        mainView.showDailyStatus(data.getDaily_forecast());
    }
}
