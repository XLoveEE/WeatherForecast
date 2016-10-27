package com.jxx.weatherforecast.model;

public  class CityInfo {
        /**
         * city : 南子岛
         * lon : 114.20
         * id : CN101310230
         * prov : 海南
         * cnty : 中国
         * lat : 11.26
         */
        private String city;
        private String lon;
        private String id;
        private String prov;
        private String cnty;
        private String lat;

        public void setCity(String city) {
            this.city = city;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setProv(String prov) {
            this.prov = prov;
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

        public String getProv() {
            return prov;
        }

        public String getCnty() {
            return cnty;
        }

        public String getLat() {
            return lat;
        }
    }