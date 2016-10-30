package com.sevenre.Service;

import com.sevenre.entity.LiveTrip;
import com.sevenre.entity.StopReference;
import com.sevenre.entity.Trace;
import com.sevenre.repository.LiveTripRepository;
import com.sevenre.repository.StopReferenceRepository;
import com.sevenre.repository.TraceRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


@Service
public class LiveTripService {

    private LiveTripRepository liveTripRepository;

    private StopReferenceRepository stopReferenceRepository;

    private TraceRepository traceRepository;

    private TraceService traceService;

    private StopReferenceService stopReferenceService;


    public LiveTripService(TraceService traceService,StopReferenceService stopReferenceService,LiveTripRepository liveTripRepository, StopReferenceRepository stopReferenceRepository, TraceRepository traceRepository) {
        this.liveTripRepository = liveTripRepository;
        this.stopReferenceRepository = stopReferenceRepository;
        this.traceRepository = traceRepository;
        this.traceService = traceService;
        this.stopReferenceService = stopReferenceService;
    }



    public List<LiveTrip> getAllTrips(){
        List<LiveTrip> liveTrips = new ArrayList<>();
        List<LiveTrip> liveTripsFinal = new ArrayList<>();

        liveTrips = liveTripRepository.findAll();
        for (LiveTrip liveTrip:liveTrips){
            long tripId = liveTrip.getTripId();
            List<Trace> traceList = traceService.getTraceById(tripId);
            List<StopReference> stopReferences = stopReferenceService.getSRById(tripId);
            liveTrip.setStopReference(stopReferences);
            liveTrip.setTrace(traceList);
            liveTripsFinal.add(liveTrip);
        }
        return liveTrips;
    }

    public long getTripId(){
        LiveTrip liveTrip = new LiveTrip();
        liveTripRepository.save(liveTrip);
        return  liveTrip.getTripId();
    }

    public String addTrips(LiveTrip liveTrip){
        liveTripRepository.save(liveTrip);
        if(liveTrip.getStopReference()!=null) {
            List<StopReference> stopReference = liveTrip.getStopReference();
            stopReferenceRepository.save(stopReference);
        }
        if(liveTrip.getTrace()!=null){
            List<Trace> trace = liveTrip.getTrace();
            traceRepository.save(trace);
        }
        return "LiveTrip created successfully!";
    }

    public String editTrip(LiveTrip liveTrip){

        if(liveTrip.getStopReference()!=null) {
            List<StopReference> stopReference = liveTrip.getStopReference();
            stopReferenceRepository.save(stopReference);
        }
        if(liveTrip.getTrace()!=null){
            List<Trace> trace = liveTrip.getTrace();
            traceRepository.save(trace);
        }

        liveTripRepository.save(liveTrip);
        return "Trip info updated successfully!";
    }

    public String deleteTrip(LiveTrip liveTrip){

        liveTripRepository.delete(liveTrip);
        return "Trip deleted successfully!";

    }

    public LiveTrip getLiveTripById( long id){

        LiveTrip liveTrip = new LiveTrip();
        liveTrip = liveTripRepository.findOne(id);
        long tripId = liveTrip.getTripId();
        List<Trace> traceList = traceService.getTraceById(tripId);
        List<StopReference> stopReferences = stopReferenceService.getSRById(tripId);
        if(traceList!=null)
             liveTrip.setStopReference(stopReferences);
        if(stopReferences!=null)
             liveTrip.setTrace(traceList);
        return liveTrip;
    }
}
