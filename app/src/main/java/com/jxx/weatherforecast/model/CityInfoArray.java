package com.jxx.weatherforecast.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jxx on 2016/10/27.
 */

public class CityInfoArray {

    private List<CityInfo> city_info; //字段名要与返回的json数据属性名称对应
    private  String status;

    public List<CityInfo> getCityinfo() {
        return city_info;
    }

    public void setCityinfo(List<CityInfo> city_info) {
        this.city_info = city_info;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
