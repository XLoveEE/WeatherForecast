package com.jxx.weatherforecast.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.jxx.weatherforecast.model.CityInfo;

import java.util.WeakHashMap;



/**
 * Created by jxx on 2016/10/10.
 */

public class WeatherDB {
    public static final String DB_NAME = "db_weatherforecast";
    public  static final  int VERSION =1;

    private SQLiteDatabase db;
    private static WeatherDB weatherDB;

    private WeatherDB(Context context){
       WeatherDBHelper weatherDBHelper = new WeatherDBHelper(context,DB_NAME,null,VERSION);
        db = weatherDBHelper.getWritableDatabase();
    }

    //单例模式
    public synchronized static WeatherDB getInstance(Context context){
        if(weatherDB==null){
            weatherDB = new WeatherDB(context);
        }
        return  weatherDB;
    }

    public void saveCityInformation(CityInfo cityInfo){
        if(cityInfo!=null){
            ContentValues values = new ContentValues();

        }
    }
}
