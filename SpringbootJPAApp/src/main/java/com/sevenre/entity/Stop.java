package com.sevenre.entity;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;


@Entity
@Table(name = "Stop_info")
public class Stop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long stopId;

    private String name;

    private double latitude;

    private double longitude;

    private String commonName;

    private String shortName;

    private String revision;



    public long getStopId() {
        return stopId;
    }

    public void setStopId(long stopId) {
        this.stopId = stopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }
}
