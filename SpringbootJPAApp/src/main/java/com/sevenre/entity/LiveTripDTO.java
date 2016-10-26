package com.sevenre.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

public class LiveTripDTO {


    private long tripId;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd,HH:mm:ss", timezone = "CET")
    private Date startTimeStamp;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd,HH:mm:ss", timezone = "CET")
    private Date endTimeStamp;

    private double startLatitude;

    private double startLongitude;

    private double endLatitude;

    private double endLongitude;

    private long driverId;

    private String polyline;

    @Type(type = "JsonTypeStopReference")
    private StopReference stopReference;


    @Type(type = "JsonTypeTrace")
    private Trace trace;

    public long getTripId() {
        return tripId;
    }

    public void setTripId(long tripId) {
        this.tripId = tripId;
    }

    public Date getStartTimeStamp() {
        return startTimeStamp;
    }

    public void setStartTimeStamp(Date startTimeStamp) {
        this.startTimeStamp = startTimeStamp;
    }

    public Date getEndTimeStamp() {
        return endTimeStamp;
    }

    public void setEndTimeStamp(Date endTimeStamp) {
        this.endTimeStamp = endTimeStamp;
    }

    public double getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(double startLatitude) {
        this.startLatitude = startLatitude;
    }

    public double getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(double startLongitude) {
        this.startLongitude = startLongitude;
    }

    public double getEndLatitude() {
        return endLatitude;
    }

    public void setEndLatitude(double endLatitude) {
        this.endLatitude = endLatitude;
    }

    public double getEndLongitude() {
        return endLongitude;
    }

    public void setEndLongitude(double endLongitude) {
        this.endLongitude = endLongitude;
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    public String getPolyline() {
        return polyline;
    }

    public void setPolyline(String polyline) {
        this.polyline = polyline;
    }

    public StopReference getStopReference() {
        return stopReference;
    }

    public void setStopReference(StopReference stopReference) {
        this.stopReference = stopReference;
    }

    public Trace getTrace() {
        return trace;
    }

    public void setTrace(Trace trace) {
        this.trace = trace;
    }
}