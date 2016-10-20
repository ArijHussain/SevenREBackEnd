package com.sevenre.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket_information")
@Getter
@Setter
public class TicketSale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ticketId;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "trip_id")
    private Trip trip;


    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd,HH:mm:ss", timezone = "CET")
    private Date timeStamp;


    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "stop_id")
    private Stop stop;

    private double price;

    private String ticketType;


}
