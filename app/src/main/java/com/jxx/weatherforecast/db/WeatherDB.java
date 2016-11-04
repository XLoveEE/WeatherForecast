package com.jxx.weatherforecast.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.jxx.weatherforecast.model.CityInfo;

import com.jxx.weatherforecast.util.ApplicationUtil;




/**
 * Created by jxx on 2016/10/10.
 */

public class WeatherDB {
    public static final String DB_NAME = "db_weatherforecast";
    public  static final  int VERSION =1;

    private SQLiteDatabase db;
    private static WeatherDB weatherDB;

    private WeatherDB(){
       WeatherDBHelper weatherDBHelper = new WeatherDBHelper(ApplicationUtil.getContext(),DB_NAME,null,VERSION);
        db = weatherDBHelper.getWritableDatabase();
    }

    //单例模式
    public synchronized static WeatherDB getInstance(){
        if(weatherDB==null){
            weatherDB = new WeatherDB();
        }
        return  weatherDB;
    }

    /**
     * 保存城市信息
     * @param cityInfo
     */
    public void saveCityInformation(CityInfo cityInfo){
        if(cityInfo!=null){
            ContentValues values = new ContentValues();
            values.put("city",cityInfo.getCity());
            values.put("cnty",cityInfo.getCnty());
            values.put("id",cityInfo.getId());
            values.put("lat",cityInfo.getLat());
            values.put("lon",cityInfo.getLon());
            values.put("prov",cityInfo.getProv());
            db.insert("tb_CityInfo",null,values);
        }
    }


}
