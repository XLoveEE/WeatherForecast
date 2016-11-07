package com.jxx.weatherforecast.model;

/**
 * Created by jxx on 2016/11/2.
 */

/***
 * 城市空气质量
 */
public class AQI {

    private  City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }



    public   class City{

        /**
         * no2 : 78
         * o3 : 26
         * pm25 : 150
         * qlty : 轻度污染
         * so2 : 13
         * aqi : 150
         * pm10 : 109
         * co : 1
         */
        private String aqi;
        private String co;
        private String no2;
        private String o3;
        private String pm10;
        private String pm25;
        private String qlty;
        private String so2;


        public void setNo2(String no2) {
            this.no2 = no2;
        }

        public void setO3(String o3) {
            this.o3 = o3;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        public void setQlty(String qlty) {
            this.qlty = qlty;
        }

        public void setSo2(String so2) {
            this.so2 = so2;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public void setPm10(String pm10) {
            this.pm10 = pm10;
        }

        public void setCo(String co) {
            this.co = co;
        }

        public String getNo2() {
            return no2;
        }

        public String getO3() {
            return o3;
        }

        public String getPm25() {
            return pm25;
        }

        public String getQlty() {
            return qlty;
        }

        public String getSo2() {
            return so2;
        }

        public String getAqi() {
            return aqi;
        }

        public String getPm10() {
            return pm10;
        }

        public String getCo() {
            return co;
        }
    }
}
