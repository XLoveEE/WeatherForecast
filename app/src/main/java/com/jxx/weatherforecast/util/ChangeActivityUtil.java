package com.jxx.weatherforecast.util;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Jxx on 2016/10/30.
 */

public class ChangeActivityUtil {
    public  static  void gotoActivity(Context context ,Class<?> activity){
        Intent intent = new Intent(context,activity);
        context.startActivity(intent);
    }
}
