package com.jxx.weatherforecast.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by jxx on 2016/10/10.
 */

public class WeatherDBHelper extends SQLiteOpenHelper {

    private Context mContext;
    public static final  String CREATE_CITYTABLE = "create table tb_CityInfo(" +
            "nid integer primary key autoincrement," +
            "city text," +
            "cnty text," +
            "id text," +
            "lat text," +
            "lon text," +
            "prov text)";
    public WeatherDBHelper(Context context, String name,
                           SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
           //创建城市信息表
            sqLiteDatabase.execSQL(CREATE_CITYTABLE);
        Toast.makeText(mContext,"Create successed",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
