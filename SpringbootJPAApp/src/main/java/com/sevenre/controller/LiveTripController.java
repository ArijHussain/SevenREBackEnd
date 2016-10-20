package com.sevenre.controller;

import com.sevenre.entity.LiveTrip;
import com.sevenre.repository.LiveTripRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ws/livetrips")
public class LiveTripController {

    private LiveTripRepository liveTripRepository;

    public LiveTripController(LiveTripRepository liveTripRepository) {
        this.liveTripRepository = liveTripRepository;
    }
    /**
     * Return all trips
     */
    @RequestMapping( method = RequestMethod.GET)
    public List<LiveTrip> getAllTrips(){
        return liveTripRepository.findAll();

    }

    /**
     * Create trip and return the generated tripID
     */

    @RequestMapping(value = "/reqtripid", method = RequestMethod.GET)
    public long getTripId(){

        LiveTrip liveTrip = new LiveTrip();
        liveTripRepository.save(liveTrip);
        return  liveTrip.getTripId();
       // TODO: Add code and logic
    }


    /**
     * Update the passed user (in RequestBody id should be the returned value of getTripId
     */

    @RequestMapping( method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String editUser(@RequestBody LiveTrip liveTrip){

        liveTripRepository.save(liveTrip);
        return "User updated successfully!";

    }

}
