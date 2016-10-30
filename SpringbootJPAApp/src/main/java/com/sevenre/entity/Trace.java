package com.sevenre.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "live_location_update")
@SqlResultSetMapping(name="tracemapping",
        classes = {
                @ConstructorResult(
                        targetClass = TraceDTO.class,
                        columns = {
                                @ColumnResult(name = "tripId",type = Long.class),
                                @ColumnResult(name = "timeStamp"),
                                @ColumnResult(name = "latitude"),
                                @ColumnResult(name = "longitude")
                        })
        })
public class Trace{



    @EmbeddedId
    private TraceKey traceKey;

    private double latitude;

    private double longitude;





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

    public TraceKey getTraceKey() {
        return traceKey;
    }

    public void setTraceKey(TraceKey traceKey) {
        this.traceKey = traceKey;
    }

}
