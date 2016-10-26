package com.sevenre.controller;

import com.sevenre.entity.Driver;
import com.sevenre.entity.Stop;
import com.sevenre.repository.StopRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/ws/stop")
public class StopController {

    private StopRepository stopRepository;


    public StopController(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }



    /**

     *
     * Save the stop
     */
    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addStops(@RequestBody List<Stop> stops){


        stopRepository.save(stops);
        return "Stops created successfully!";

    }
    /**
     * Return all stops
     */
    @RequestMapping( method = RequestMethod.GET)
    public List<Stop> getAllStops(){
        return stopRepository.findAll();

    }

    /**
     * Update Stop
     */
    @RequestMapping( method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateStop(@RequestBody Stop stop){
        stopRepository.save(stop);
        return "Stop information updated successfully!";
    }


    /**
     * Delete the stop
     */
    @RequestMapping( method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteStop(@RequestBody Stop stop){

        stopRepository.delete(stop);
        return "Stop deleted successfully!";

    }


    /**
     * Return the Stop with the specific stopID
     */
    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public Stop getStopById(@PathVariable long id){
        return stopRepository.findOne(id);

    }

}
