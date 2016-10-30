package com.sevenre.Service;

import com.sevenre.entity.Stop;
import com.sevenre.repository.StopRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by Arij on 10/30/2016.
 */
@Service
public class StopService {

    private StopRepository stopRepository;


    public StopService(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }

    public String addStops(List<Stop> stops){
        stopRepository.save(stops);
        return "Stops created successfully!";
    }

    public List<Stop> getAllStops(){
        return stopRepository.findAll();
    }

    public String updateStop(Stop stop){
        stopRepository.save(stop);
        return "Stop information updated successfully!";
    }

    public String deleteStop(Stop stop){
        stopRepository.delete(stop);
        return "Stop deleted successfully!";
    }

    public Stop getStopById(long id){
        return stopRepository.findOne(id);
    }
}
