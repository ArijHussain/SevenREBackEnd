package com.sevenre.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Arij on 10/30/2016.
 */
public class TraceDTO implements Serializable{

    public TraceDTO(long tripId,Date timeStamp, double latitude, double longitude) {
        this.tripId = tripId;
        this.timeStamp = timeStamp;
        this.latitude = latitude;
        this.longitude = longitude;

    }


    private long tripId;

    private Date timeStamp;

    private double latitude;

    private double longitude;



    public long getTripId() {
        return tripId;
    }

    public void setTripId(long tripId) {
        this.tripId = tripId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
