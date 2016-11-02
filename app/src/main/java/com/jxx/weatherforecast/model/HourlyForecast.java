package com.jxx.weatherforecast.model;

/**
 * Created by jxx on 2016/11/2.
 */

public class HourlyForecast {


    /**
     * date : 2016-11-02 19:00
     * pop : 0
     * hum : 42
     * pres : 1026
     * tmp : 10
     */
    private String date;
    private String hum;
    private String pop;
    private String pres;
    private String tmp;
    private Wind wind;

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public void setPres(String pres) {
        this.pres = pres;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
    }

    public String getDate() {
        return date;
    }

    public String getPop() {
        return pop;
    }

    public String getHum() {
        return hum;
    }

    public String getPres() {
        return pres;
    }

    public String getTmp() {
        return tmp;
    }

    class  Wind{

        /**
         * sc : 微风
         * spd : 9
         * deg : 252
         * dir : 西南风
         */
        private String deg;
        private String dir;
        private String sc;
        private String spd;

        public void setSc(String sc) {
            this.sc = sc;
        }

        public void setSpd(String spd) {
            this.spd = spd;
        }

        public void setDeg(String deg) {
            this.deg = deg;
        }

        public void setDir(String dir) {
            this.dir = dir;
        }

        public String getSc() {
            return sc;
        }

        public String getSpd() {
            return spd;
        }

        public String getDeg() {
            return deg;
        }

        public String getDir() {
            return dir;
        }
    }
}
