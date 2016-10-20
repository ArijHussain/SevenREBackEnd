package com.sevenre.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "stop_information")
@Getter
@Setter
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



}
