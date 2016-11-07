package com.jxx.weatherforecast.model;

/**
 * Created by jxx on 2016/11/2.
 */

public class Suggestion {

    private  SuggItem comf;
    private  SuggItem cw;
    private  SuggItem drsg;
    private  SuggItem flu;
    private  SuggItem sport;
    private  SuggItem trav;
    private  SuggItem uv;

    public class SuggItem{
        private  String brf;
        private  String txt;

        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }

        public String getBrf() {
            return brf;
        }

        public void setBrf(String brf) {
            this.brf = brf;
        }
    }
}
