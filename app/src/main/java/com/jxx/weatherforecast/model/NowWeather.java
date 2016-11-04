package com.jxx.weatherforecast.model;

/**
 * Created by jxx on 2016/11/2.
 */

public class NowWeather {


    /**
     * hum : 44
     * vis : 10
     * pres : 1023
     * pcpn : 0
     * fl : 9
     * tmp : 10
     */
    private Cond cond;
    private String fl;
    private String hum;
    private String pcpn;
    private String pres;
    private String tmp;
    private String vis;

    private Wind wind;

    public Cond getCond() {
        return cond;
    }

    public void setCond(Cond cond) {
        this.cond = cond;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }



    public void setHum(String hum) {
        this.hum = hum;
    }

    public void setVis(String vis) {
        this.vis = vis;
    }

    public void setPres(String pres) {
        this.pres = pres;
    }

    public void setPcpn(String pcpn) {
        this.pcpn = pcpn;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
    }

    public String getHum() {
        return hum;
    }

    public String getVis() {
        return vis;
    }

    public String getPres() {
        return pres;
    }

    public String getPcpn() {
        return pcpn;
    }

    public String getFl() {
        return fl;
    }

    public String getTmp() {
        return tmp;
    }

    public String getCondCode(){
        return  cond.getCode();
    }
    public String getCondTxT(){
        return cond.getTxt();
    }

    public String getWindDir(){
        return this.wind.getDir();
    }
    public String getWindSc(){
        return  this.wind.getSc();
    }


    class Cond{

        /**
         * txt : 晴
         * code : 100
         */
        private String code;
        private String txt;


        public void setTxt(String txt) {
            this.txt = txt;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getTxt() {
            return txt;
        }

        public String getCode() {
            return code;
        }
    }
    class Wind{


        /**
         * sc : 4-5
         * spd : 24
         * deg : 200
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
