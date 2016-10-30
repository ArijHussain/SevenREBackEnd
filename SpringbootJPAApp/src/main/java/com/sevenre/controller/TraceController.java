package com.sevenre.controller;

import com.sevenre.Service.TraceService;
import com.sevenre.entity.LiveTrip;
import com.sevenre.entity.Trace;
import com.sevenre.entity.TraceKey;
import com.sevenre.repository.TraceRepository;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Arij on 10/29/2016.
 */
@RestController
@RequestMapping(value = "/ws/trace")
public class TraceController {


        private TraceService traceService;

    public TraceController(TraceService traceService) {
        this.traceService = traceService;
    }


    /**
     * Return the Trace with the specific tripId and timestamp
     */
    @RequestMapping(method = RequestMethod.GET , value = "/{id}")
    public List<Trace> getTraceById(@PathVariable long id)  {


        return traceService.getTraceById(id) ;

    }


}
