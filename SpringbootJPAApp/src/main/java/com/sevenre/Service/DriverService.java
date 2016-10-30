package com.sevenre.Service;

import com.sevenre.entity.Driver;
import com.sevenre.repository.DriverRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by Arij on 10/30/2016.
 */
@Service
public class DriverService {

    private DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public String addDrivers(List<Driver> drivers){
        driverRepository.save(drivers);
        return "Driver created successfully!";

    }

    public List<Driver> getAllDrivers(){
        return driverRepository.findAll();

    }

    public String updateDriver(Driver driver){
        driverRepository.save(driver);
        return "Driver information updated successfully!";
    }

    public String deleteDriver( Driver driver){

        driverRepository.delete(driver);
        return "Driver deleted successfully!";

    }

    public Driver getDriverById(long id){
        return driverRepository.findOne(id);

    }
}
