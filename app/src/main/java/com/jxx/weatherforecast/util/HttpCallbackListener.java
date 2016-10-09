package com.jxx.weatherforecast.util;

/**
 * Created by jxx on 2016/10/9.
 */

public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
