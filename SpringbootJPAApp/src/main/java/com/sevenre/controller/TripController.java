package com.sevenre.controller;

import com.sevenre.entity.Trip;
import com.sevenre.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ws/trips")
public class TripController {

    private TripRepository tripRepository;

    @Autowired
    public TripController(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    /**
     * Return all trips
     */
    @RequestMapping( method = RequestMethod.GET)
    public List<Trip> getAllTrips(){
        return tripRepository.findAll();

    }


    /**
     * Save the trips
     */
    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addTrips(@RequestBody List<Trip> trips){

        for(Trip trip:trips) {
            tripRepository.save(trip);
        }
        return "Trip created successfully!";

    }

    /**
     * Update the trip
     */
    @RequestMapping( method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateTrip(@RequestBody Trip trip){


        tripRepository.save(trip);
        return "Trip updated successfully!";

    }

    /**
     * Delete the trip
     */
    @RequestMapping( method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteTrip(@RequestBody Trip trip){


        tripRepository.delete(trip);
        return "Trip deleted successfully!";

    }


    /**
     * Return the trip with the specific tripId
     */
    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public Trip getTripById(@PathVariable long id){
        return tripRepository.findOne(id);

    }
}
