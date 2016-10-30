package com.sevenre.controller;


import com.sevenre.Service.DriverService;
import com.sevenre.entity.Driver;
import com.sevenre.repository.DriverRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ws/driver")
public class DriverController {




    private DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }


    /**
     * Example request body :
     *
     * [{
     "firstName": "Arij",
     "lastName": "Hussain",
     "dob": 1476057600000,
     "pin": 1234,
     "mobileNo": 123456789,
     "address": {
     "street": "PirmaStr",
     "city": "Kaiserslautern",
     "zip": "67655"
     },
     "email": "a@bc.com"
     }]
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     * Save the drivers
     */
    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addDrivers(@RequestBody List<Driver> drivers){


        return driverService.addDrivers(drivers);

    }
    /**
     * Return all drivers
     */
    @RequestMapping( method = RequestMethod.GET)
    public List<Driver> getAllDrivers(){

        return driverService.getAllDrivers();
    }

   /**
     * Update driver
     */
    @RequestMapping( method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateDriver(@RequestBody Driver driver){

        return driverService.updateDriver(driver);
    }


    /**
     * Delete the driver
     */
    @RequestMapping( method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteDriver(@RequestBody Driver driver){

        return driverService.deleteDriver(driver);

    }


    /**
     * Return the driver with the specific driverID
     */
    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public Driver getDriverById(@PathVariable long id){
        return driverService.getDriverById(id);

    }


}
