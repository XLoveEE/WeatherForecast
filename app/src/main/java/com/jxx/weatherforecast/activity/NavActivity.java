package com.jxx.weatherforecast.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
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
import com.jxx.weatherforecast.util.ChangeActivityUtil;
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


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onStop() {
        super.onStop();
        this.finish();
        Logger.d("onStop");
    }

    private void InitInfo(){

       final SharedPreferences sharedPreferences = getSharedPreferences("Config", Context.MODE_PRIVATE);
        final boolean isFirst = sharedPreferences.getBoolean("isFirst",false);
        if(!isFirst){
            Logger.d("加载初始化数据!");
            final   ProgressDialog myDialog = ProgressDialog.show(NavActivity.this,
                    "正在初始化..", "玩命加载中", true, true);
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
                    myDialog.dismiss();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isFirst",true);
                    editor.commit();
                    ChangeActivityUtil.gotoActivity(NavActivity.this,MainActivity.class);
                }

                @Override
                public void onError(Exception e) {
                    Logger.d(e.getMessage());
                    myDialog.dismiss();
                }
            });
        }else{
            ChangeActivityUtil.gotoActivity(NavActivity.this,MainActivity.class);
        }


        //预加载天气信息到数据库
    }

}
