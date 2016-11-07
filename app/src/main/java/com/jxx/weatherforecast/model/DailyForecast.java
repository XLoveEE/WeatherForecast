package com.jxx.weatherforecast.model;

/**
 * Created by jxx on 2016/11/2.
 */

public class DailyForecast {

    private  Astro astro;
    private  Cond cond;

    private String date;
    private String hum;
    private String pcpn;
    private String pop;
    private String pres;
    private Tmp tmp;//温度
    private String vis;
    private Wind wind;

    public Astro getAstro() {
        return astro;
    }

    public void setAstro(Astro astro) {
        this.astro = astro;
    }

    public Cond getCond() {
        return cond;
    }

    public void setCond(Cond cond) {
        this.cond = cond;
    }

    public Tmp getTmp() {
        return tmp;
    }

    public void setTmp(Tmp tmp) {
        this.tmp = tmp;
    }

    public String getVis() {
        return vis;
    }

    public void setVis(String vis) {
        this.vis = vis;
    }

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

    public void setPcpn(String pcpn) {
        this.pcpn = pcpn;
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

    public String getPcpn() {
        return pcpn;
    }

    class Astro{

        /**
         * ss : 17:11
         * sr : 06:44
         */
        private String sr;
        private String ss;


        public void setSs(String ss) {
            this.ss = ss;
        }

        public void setSr(String sr) {
            this.sr = sr;
        }

        public String getSs() {
            return ss;
        }

        public String getSr() {
            return sr;
        }
    }

    class  Cond{

        /**
         * txt_n : 晴
         * code_n : 100
         * code_d : 100
         * txt_d : 晴
         */
        private String code_d;
        private String code_n;
        private String txt_d;
        private String txt_n;




        public void setTxt_n(String txt_n) {
            this.txt_n = txt_n;
        }

        public void setCode_n(String code_n) {
            this.code_n = code_n;
        }

        public void setCode_d(String code_d) {
            this.code_d = code_d;
        }

        public void setTxt_d(String txt_d) {
            this.txt_d = txt_d;
        }

        public String getTxt_n() {
            return txt_n;
        }

        public String getCode_n() {
            return code_n;
        }

        public String getCode_d() {
            return code_d;
        }

        public String getTxt_d() {
            return txt_d;
        }
    }

    class Tmp{

        /**
         * min : 0
         * max : 12
         */
        private String max;
        private String min;

        public void setMin(String min) {
            this.min = min;
        }

        public void setMax(String max) {
            this.max = max;
        }

        public String getMin() {
            return min;
        }

        public String getMax() {
            return max;
        }
    }

    class Wind{

        /**
         * sc : 微风
         * spd : 7
         * deg : 276
         * dir : 无持续风向
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
