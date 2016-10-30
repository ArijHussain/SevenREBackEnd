package com.sevenre.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Arij on 10/30/2016.
 */
public class StopReferenceDTO implements Serializable{

    private long tripId;

    private Date timeStamp;

    private long stopId;

    public StopReferenceDTO(long tripId, Date timeStamp, long stopId) {
        this.tripId = tripId;
        this.timeStamp = timeStamp;
        this.stopId = stopId;
    }

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

    public long getStopId() {
        return stopId;
    }

    public void setStopId(long stopId) {
        this.stopId = stopId;
    }
}
