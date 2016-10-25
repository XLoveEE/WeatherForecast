package com.jxx.weatherforecast.model;

import android.content.Context;
import android.widget.Toast;

import com.jxx.weatherforecast.util.HttpCallbackListener;

/**
 * Created by jxx on 2016/10/25.
 */

public class CityInfoHttpCallbackListener implements HttpCallbackListener {

    Context mContext;
    public CityInfoHttpCallbackListener(Context context) {
        super();
        this.mContext = context;
    }

    @Override
    public void onFinish(String response) {

    }

    @Override
    public void onError(Exception e) {
        Toast.makeText(mContext,"保存城市信息失败!",Toast.LENGTH_LONG).show();
    }
}
