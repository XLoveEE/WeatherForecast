package com.jxx.weatherforecast.impl;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.jxx.weatherforecast.db.WeatherDB;
import com.jxx.weatherforecast.model.CityInfo;
import com.jxx.weatherforecast.model.CityInfoArray;
import com.jxx.weatherforecast.presenter.INavPresenter;
import com.jxx.weatherforecast.util.HttpCallbackListener;
import com.jxx.weatherforecast.util.HttpUtils;
import com.jxx.weatherforecast.view.INavVIew;

/**
 * Created by Jxx on 2016/11/4.
 */

public class NavPresenterImpl implements INavPresenter {
    private Context mcontext;
    private INavVIew mnavVIew;


    public NavPresenterImpl(Context context , INavVIew navView){
        this.mcontext = context;
        this.mnavVIew = navView;
    }

    @Override
    public void InitInformation() {
        final SharedPreferences sharedPreferences = mcontext.getSharedPreferences("Config",Context.MODE_PRIVATE);
        boolean isfirst =  sharedPreferences.getBoolean("isFirst",false);
        if(!isfirst){
            final ProgressDialog myDialog = ProgressDialog.show(mcontext,
                    "正在初始化..", "玩命加载中", true, true);
            //设置点击屏幕和返回键，diaog不消失
            myDialog.setCancelable(false);
            //加载城市信息
            HttpUtils.HttpGetJson("https://api.heweather.com/x3/citylist?search=allchina&key=77d857413f1845949c1f28207f3319d9", new HttpCallbackListener() {
                @Override
                public void onFinish(byte[] bytes) {

                }
                @Override
                public void onFinish(String response) {

                    Gson gson = new Gson();
                    CityInfoArray cityInfoArray = gson.fromJson(response,CityInfoArray.class);
                    for(CityInfo city : cityInfoArray.getCityinfo()){
                        WeatherDB.getInstance().saveCityInformation(city);
                    }
                    myDialog.dismiss();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isFirst",true);
                    editor.commit();
                    mnavVIew.SwitchToMainActivity();
                }
                @Override
                public void onError(Exception e) {
                    myDialog.dismiss();
                }
            });

        }else{
            mnavVIew.SwitchToMainActivity();
        }
    }


}
