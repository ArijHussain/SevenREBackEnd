package com.sevenre.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "driver_information")
@Getter
@Setter
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long driverId;

    private String firstName;

    private String lastName;

    private Date dob;

    private int pin;

    private double mobileNo;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    private String email;


}



