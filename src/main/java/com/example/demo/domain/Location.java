package com.example.demo.domain;


public class Location {
    private double lng;
    private double lat;

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public Location(double lng, double lat) {

        this.lng = lng;
        this.lat = lat;
    }
}
