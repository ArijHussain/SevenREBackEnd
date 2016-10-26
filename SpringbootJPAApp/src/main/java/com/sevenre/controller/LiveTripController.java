package com.sevenre.controller;

import com.sevenre.entity.*;
import com.sevenre.repository.LiveTripRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
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
     * Save the livetrip
     */
    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addUser(@RequestBody List<LiveTrip> liveTrips){

        liveTripRepository.save(liveTrips);
        return "LiveTrip created successfully!";

    }


    /**
     * Update the passed user (in RequestBody id should be the returned value of getTripId
     */

    @RequestMapping( method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String editUser(@RequestBody LiveTrip liveTrip)  throws IOException{

       /* Long id = liveTrip.getTripId();
        LiveTrip existing = getLiveTripById(id);
        Trace trace = new Trace();
        if (existing != null ){
            trace = existing.getTrace();
        }


            traceList.add(trace1);


            traceList.add(trace2);


        liveTrip.setTrace(traceList);*/
       /* LiveTrip liveTrip = new LiveTrip();

        String json = readUrl("http://localhost:8080/ws/driver/"+liveTripDTO.getDriverId());
        Gson gson = new Gson();
        Type type = new TypeToken<Driver>() {}.getType();

        Driver driver = gson.fromJson(json, type);
        liveTrip.setDriverId(driver);
        liveTrip.setEndLatitude(liveTripDTO.getEndLatitude());
        liveTrip.setEndLongitude(liveTripDTO.getEndLongitude());*/

        //Driver

        liveTripRepository.save(liveTrip);
        return "User updated successfully!";

    }

    /**
     * Return the user with the specific userId
     */
    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public LiveTrip getLiveTripById(@PathVariable long id){
        return liveTripRepository.findOne(id);

    }

    //read URL
    public String readUrl(String urlString) throws IOException {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

}
