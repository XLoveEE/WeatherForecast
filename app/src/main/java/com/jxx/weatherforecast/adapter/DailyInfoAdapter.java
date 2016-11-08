package com.jxx.weatherforecast.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jxx.weatherforecast.R;
import com.jxx.weatherforecast.model.DailyForecast;

import java.util.List;

/**
 * Created by jxx on 2016/11/8.
 */

public class DailyInfoAdapter extends ArrayAdapter<DailyForecast> {
    private  int resourceid;

    public DailyInfoAdapter(Context context, int resource, int textViewResourceId, List<DailyForecast> objects) {
        super(context, resource, textViewResourceId, objects);
        this.resourceid = textViewResourceId;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DailyForecast dailyForecast =  getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceid,null);
        TextView tv_maxTmp = (TextView) view.findViewById(R.id.tv_maxTemp);
        TextView tv_minTmp = (TextView) view.findViewById(R.id.tv_minTemp);
        TextView tv_cond = (TextView)view.findViewById(R.id.tv_cond);
        ImageView img = (ImageView)view.findViewById(R.id.img_wheather);

        tv_maxTmp.setText(dailyForecast.getTmp().getMax());
        tv_minTmp.setText(dailyForecast.getTmp().getMin());
        tv_cond.setText(dailyForecast.getCond().getTxt_n());
        return  view;
    }
}
