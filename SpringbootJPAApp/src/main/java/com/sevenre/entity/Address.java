package com.sevenre.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "address")
@Getter
@Setter
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String street;

    private String city;

    private String zip;


}
