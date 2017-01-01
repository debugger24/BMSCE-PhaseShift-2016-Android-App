package me.rahulk.adtphaseshift2016;

import android.content.Intent;

/**
 * Created by rahulcomp24 on 08/09/16.
 */
public class EventLocation {
    private double lat;
    private double lon;
    private String title;
    private String locationDescription;
    private int zoomLevel;

    public EventLocation (double lat, double lon, String title, int zoomLevel, String locationDescription) {
        this.lat = lat;
        this.lon = lon;
        this.title = title;
        this.zoomLevel = zoomLevel;
        this.locationDescription = locationDescription;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getTitle() {
        return title;
    }

    public int getZoomLevel() {
        return zoomLevel;
    }

    public String getLocationDescription() {
        return locationDescription;
    }
}
