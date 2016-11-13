package com.jxx.weatherforecast.activity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.jxx.weatherforecast.R;

import com.jxx.weatherforecast.adapter.DailyInfoAdapter;
import com.jxx.weatherforecast.impl.MainPresenterImpl;
import com.jxx.weatherforecast.model.AQI;
import com.jxx.weatherforecast.model.DailyForecast;
import com.jxx.weatherforecast.model.HourlyForecast;
import com.jxx.weatherforecast.model.NowWeather;
import com.jxx.weatherforecast.model.WeatherInfo;
import com.jxx.weatherforecast.view.IMainView;

import java.util.List;


public class MainActivity extends BaseActivity implements IMainView, View.OnClickListener {

    private String selectedCity;


    private  WeatherInfo weatherInfo=null;
    private TextView tv_tmpvalue;
    private TextView tv_weatherstatus;
    private TextView tv_windstatus;
    private TextView tv_windvalue;
    private TextView tv_humvalue;
    private TextView tv_airstatus;
    private TextView tv_airvalue;
    private ListView lv_daily;
    private TextView tv_setting;

    private List<DailyForecast> dailyList;
    private MainPresenterImpl mainPresenter;

//    Handler handler  = new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//           switch (msg.arg1){
//               case 1:{
//                  mainPresenter.UpdateWeatherInfo((WeatherInfo)msg.obj);
//               }
//           }
//        }
//    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitView();
        mainPresenter = new MainPresenterImpl(this);
        mainPresenter.UpdateWeatherInfo();

    }

    private void InitView() {
        tv_tmpvalue = (TextView)findViewById(R.id.tv_tmpvalue);
        tv_weatherstatus = (TextView)findViewById(R.id.tb_weatherstatus);
        tv_windstatus = (TextView)findViewById(R.id.tv_windstatus);
        tv_windvalue = (TextView)findViewById(R.id.tb_windvalue);
        tv_humvalue = (TextView)findViewById(R.id.tv_humvalue);
        tv_airstatus = (TextView)findViewById(R.id.tv_airstatus);
        tv_airvalue = (TextView)findViewById(R.id.tv_airvalue);
        tv_setting = (TextView)findViewById(R.id.tv_setting);
        lv_daily = (ListView)findViewById(R.id.lv_daily);


        tv_setting.setOnClickListener(this);
    }



    /**
     * 显示当天天气信息
     * @param data
     */
    @Override
    public void showNowStatus(final NowWeather data) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(data!=null){
                    Log.d("weather","showNowStatus");
                    tv_tmpvalue.setText(data.getTmp());
                    tv_weatherstatus.setText(data.getCond().getTxt());
                    tv_windstatus.setText(data.getWind().getDir());
                    tv_windvalue.setText(data.getWind().getSc());
                    tv_humvalue.setText(data.getHum());
                }

            }
        });

    }

    /**
     * 显示未来三天信息
     * @param data
     */
    @Override
    public void showDailyStatus(final List<DailyForecast> data) {
        Log.d("weather","showDailyStatus");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                DailyInfoAdapter adapter = new DailyInfoAdapter(MainActivity.this,
                        R.layout.instantiating_item,R.layout.weather_item,data);
                lv_daily.setAdapter(adapter);
            }
        });
    }

    /**
     * 显示未来三小时信息
     * @param data
     */
    @Override
    public void showHourlyStatus(HourlyForecast data) {

    }

    @Override
    public void showAqiStatus(AQI data) {
        if(data!=null){
            tv_airstatus.setText(data.getCity().getQlty());
            tv_airvalue.setText(data.getCity().getAqi());
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.tv_setting:{
                mainPresenter.UpdateWeatherInfo();
                break;
            }
        }
    }
}
