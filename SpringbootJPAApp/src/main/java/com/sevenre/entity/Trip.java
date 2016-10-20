package com.sevenre.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "trips")
@Getter
@Setter
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tripId;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd,HH:mm", timezone = "CET")
    private Date startTime;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd,HH:mm", timezone = "CET")
    private Date endTime;

    /*@OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "trace_id")
    private Trace trace;*/

}
