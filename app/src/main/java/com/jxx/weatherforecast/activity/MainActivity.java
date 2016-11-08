package com.jxx.weatherforecast.activity;

import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jxx.weatherforecast.R;

import com.jxx.weatherforecast.adapter.DailyInfoAdapter;
import com.jxx.weatherforecast.impl.MainPresenterImpl;
import com.jxx.weatherforecast.model.AQI;
import com.jxx.weatherforecast.model.DailyForecast;
import com.jxx.weatherforecast.model.HourlyForecast;
import com.jxx.weatherforecast.model.NowWeather;
import com.jxx.weatherforecast.model.WeatherInfo;
import com.jxx.weatherforecast.util.HttpCallbackListener;
import com.jxx.weatherforecast.util.HttpUtils;
import com.jxx.weatherforecast.view.IMainView;

import java.util.List;


public class MainActivity extends BaseActivity implements IMainView{

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

    private List<DailyForecast> dailyList;
    private MainPresenterImpl mainPresenter;

    Handler handler  = new Handler(){
        @Override
        public void handleMessage(Message msg) {
           switch (msg.arg1){
               case 1:{
                  mainPresenter.UpdateWeatherInfo((WeatherInfo)msg.obj);
               }
           }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenterImpl(this);
        UpdateWeatherInformation();
        InitView();
    }

    private void InitView() {
        tv_tmpvalue = (TextView)findViewById(R.id.tv_tmpvalue);
        tv_weatherstatus = (TextView)findViewById(R.id.tb_weatherstatus);
        tv_windstatus = (TextView)findViewById(R.id.tv_windstatus);
        tv_windvalue = (TextView)findViewById(R.id.tb_windvalue);
        tv_humvalue = (TextView)findViewById(R.id.tv_humvalue);
        tv_airstatus = (TextView)findViewById(R.id.tv_airstatus);
        tv_airvalue = (TextView)findViewById(R.id.tv_airvalue);
        lv_daily = (ListView)findViewById(R.id.lv_daily);



    }


    private  void UpdateWeatherInformation(){
        HttpUtils.HttpGetJson("https://api.heweather.com/x3/weather?cityid=CN101010100&key=77d857413f1845949c1f28207f3319d9"
                , new HttpCallbackListener() {
                    @Override
                    public void onFinish(byte[] bytes) {

                    }

                    @Override
                    public void onFinish(String response) {
                        Gson gson = new Gson();
                        response = response.substring(31,response.length()-2);
                        weatherInfo = gson.fromJson(response,WeatherInfo.class);

                        Message msg = new Message();
                        msg.arg1 = 1;
                        msg.obj = weatherInfo;
                        handler.sendMessage(msg);
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
    }

    /**
     * 显示当天天气信息
     * @param data
     */
    @Override
    public void showNowStatus(NowWeather data) {
        if(data!=null){
            tv_tmpvalue.setText(data.getTmp());
            tv_weatherstatus.setText(data.getCond().getTxt());
            tv_windstatus.setText(data.getWind().getDir());
            tv_windvalue.setText(data.getWind().getSc());
            tv_humvalue.setText(data.getHum());
        }
    }

    /**
     * 显示未来三天信息
     * @param data
     */
    @Override
    public void showDailyStatus(List<DailyForecast> data) {
        DailyInfoAdapter adapter = new DailyInfoAdapter(MainActivity.this,
                R.layout.instantiating_item,R.layout.weather_item,data);
        lv_daily.setAdapter(adapter);
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
}
