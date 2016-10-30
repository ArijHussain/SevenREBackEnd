package com.sevenre.controller;

import com.sevenre.Service.StopService;
import com.sevenre.entity.Driver;
import com.sevenre.entity.Stop;
import com.sevenre.repository.StopRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/ws/stop")
public class StopController {

    private StopService stopService;

    public StopController(StopService stopService) {
        this.stopService = stopService;
    }


    /**

     *
     * Save the stop
     */
    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addStops(@RequestBody List<Stop> stops){

        return stopService.addStops(stops);

    }
    /**
     * Return all stops
     */
    @RequestMapping( method = RequestMethod.GET)
    public List<Stop> getAllStops(){
        return stopService.getAllStops();

    }

    /**
     * Update Stop
     */
    @RequestMapping( method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateStop(@RequestBody Stop stop){
        return stopService.updateStop(stop);
    }


    /**
     * Delete the stop
     */
    @RequestMapping( method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteStop(@RequestBody Stop stop){

        return stopService.deleteStop(stop);

    }


    /**
     * Return the Stop with the specific stopID
     */
    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public Stop getStopById(@PathVariable long id){
        return stopService.getStopById(id);

    }

}
