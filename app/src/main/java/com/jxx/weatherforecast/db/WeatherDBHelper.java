package com.jxx.weatherforecast.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jxx on 2016/10/10.
 */

public class WeatherDBHelper extends SQLiteOpenHelper {

    private Context mContext;
    public static final  String CREATE_CITYTABLE = "create table tb_CityInfo(" +
            "nid integer primary key autoincrement," +
            "city text," +
            "cnty text," +
            "id text unique," +
            "lat text," +
            "lon text," +
            "prov text)";
    public  static final String CREATE_CONDTABLE = "create table tb_Cond(" +
            "nid integer primary key autoincrement," +
            "code text unique," +
            "txt text" +
            "txt_en text" +
            "icon text)";
    public WeatherDBHelper(Context context, String name,
                           SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    /**
     * 第一次运行时执行
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
           //创建城市信息表
            sqLiteDatabase.execSQL(CREATE_CITYTABLE);
            //创建天气信息表
            sqLiteDatabase.execSQL(CREATE_CONDTABLE);
        //Toast.makeText(mContext,"Create successed",Toast.LENGTH_LONG).show();
    }

    /**
     * 更新数据库
     * @param sqLiteDatabase
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
