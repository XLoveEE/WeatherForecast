package com.jxx.weatherforecast.model;

/**
 * Created by jxx on 2016/11/2.
 */

/***
 * 基本天气信息
 */
public class BasicWeather {

    /**
     * city : 北京
     * lon : 116.391000
     * id : CN101010100
     * cnty : 中国
     * lat : 39.904000
     */
    private String city;
    private String cnty;
    private String id;
    private String lat;
    private String lon;
    private Update update;





    public void setCity(String city) {
        this.city = city;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCnty(String cnty) {
        this.cnty = cnty;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getCity() {
        return city;
    }

    public String getLon() {
        return lon;
    }

    public String getId() {
        return id;
    }

    public String getCnty() {
        return cnty;
    }

    public String getLat() {
        return lat;
    }

    public Update getUpdate() {
        return update;
    }



    public class  Update{
        private  String loc;
        private  String utc;

        public String getLoc() {
            return loc;
        }

        public void setLoc(String loc) {
            this.loc = loc;
        }

        public String getUtc() {
            return utc;
        }

        public void setUtc(String utc) {
            this.utc = utc;
        }
    }
}
