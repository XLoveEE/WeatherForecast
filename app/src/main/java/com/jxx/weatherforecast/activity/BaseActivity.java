package com.jxx.weatherforecast.activity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jxx.weatherforecast.R;

public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String getWeatherKey(){
        String keyvalue = null;
        //读取配置文件中的key值
        try {
            ApplicationInfo applicationInfo = this.getPackageManager()
                    .getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);

            keyvalue = applicationInfo.metaData.getString("WeatherAPI_KEY");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return keyvalue;
    }

}
