package com.sevenre.controller;

import com.sevenre.Service.LiveTripService;
import com.sevenre.Service.StopReferenceService;
import com.sevenre.Service.TraceService;
import com.sevenre.entity.*;
import com.sevenre.repository.LiveTripRepository;
import com.sevenre.repository.StopReferenceRepository;
import com.sevenre.repository.TraceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/ws/livetrips")
public class LiveTripController {





    private LiveTripService liveTripService;

    public LiveTripController(LiveTripService liveTripService) {
        this.liveTripService = liveTripService;
    }


    /**
     * Return all trips
     */
    @RequestMapping( method = RequestMethod.GET)
    public List<LiveTrip> getAllTrips(){

        return liveTripService.getAllTrips();

    }

    /**
     * Create trip and return the generated tripID
     */

    @RequestMapping(value = "/reqtripid", method = RequestMethod.GET)
    public long getTripId(){

        return  liveTripService.getTripId();
    }



    /**
     * Save the live trips
     */
    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addTrips(@RequestBody LiveTrip liveTrip){

        return  liveTripService.addTrips(liveTrip);

    }


    /**
     * Update the passed trip (in RequestBody id should be the returned value of getTripId)
     */

    @RequestMapping( method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String editTrip(@RequestBody LiveTrip liveTrip) {

        return liveTripService.editTrip(liveTrip);

    }


    /**
     * Delete the live trip
     */
    @RequestMapping( method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteTrip(@RequestBody LiveTrip liveTrip){

        return liveTripService.deleteTrip(liveTrip);

    }

    /**
     * Return the Trip with the specific tripId
     */
    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public LiveTrip getLiveTripById(@PathVariable long id){

       return liveTripService.getLiveTripById(id);

    }



}
