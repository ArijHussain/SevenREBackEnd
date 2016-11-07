package com.sevenre.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "livetrips_info")
public class LiveTrip {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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



    /*@Type(type = "JsonTypeStopReference")
    private StopReference stopReference;*/

    @Transient
    private List<StopReference> stopReferences;



    @Transient
    private List<Trace> traces;

    /*@Type(type = "JsonTypeTrace")
    private Trace trace;*/


    public List<StopReference> getStopReference() {
        return stopReferences;
    }

    public void setStopReference(List<StopReference> stopReferences) {
        this.stopReferences = stopReferences;
    }

    public List<Trace> getTrace() {
        return traces;
    }

    public void setTrace(List<Trace> traces) {
        this.traces = traces;
    }

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


    public String getPolyline() {
        return polyline;
    }

    public void setPolyline(String polyline) {
        this.polyline = polyline;
    }

 /*   public Driver getDriverId() {
        return driverId;
    }

    public void setDriverId(Driver driverId) {
        this.driverId = driverId;
    }*/


    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }
}
