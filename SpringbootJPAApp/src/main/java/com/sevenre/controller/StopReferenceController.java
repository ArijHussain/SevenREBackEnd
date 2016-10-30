package com.sevenre.controller;

import com.sevenre.Service.StopReferenceService;
import com.sevenre.entity.StopReference;
import com.sevenre.entity.StopReferenceKey;
import com.sevenre.entity.Trace;
import com.sevenre.entity.TraceKey;
import com.sevenre.repository.StopReferenceRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Arij on 10/29/2016.
 */

@RestController
@RequestMapping(value = "/ws/stopref")
public class StopReferenceController {

   private StopReferenceService stopReferenceService;

    public StopReferenceController(StopReferenceService stopReferenceService) {
        this.stopReferenceService = stopReferenceService;
    }


    /**
     * Return the Stop Reference with the specific tripId and timestamp
     */
    @RequestMapping(method = RequestMethod.GET , value = "/{id}")
    public List<StopReference> getSRById(@PathVariable long id)  {

        return stopReferenceService.getSRById(id);

    }
}
