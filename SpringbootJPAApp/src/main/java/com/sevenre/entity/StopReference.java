package com.sevenre.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "stop_reference")
@SqlResultSetMapping(name="stopmapping",
        classes = {
                @ConstructorResult(
                        targetClass = StopReferenceDTO.class,
                        columns = {
                                @ColumnResult(name = "tripId",type = Long.class),
                                @ColumnResult(name = "timeStamp"),
                                @ColumnResult(name = "stopId",type = Long.class)
                        })
        })
public class StopReference
{

    @EmbeddedId
    private StopReferenceKey myKey;

    private long stopId;



    public long getStopId() {
        return stopId;
    }

    public void setStopId(long stopId) {
        this.stopId = stopId;
    }


    public StopReferenceKey getMyKey() {
        return myKey;
    }

    public void setMyKey(StopReferenceKey myKey) {
        this.myKey = myKey;
    }
}