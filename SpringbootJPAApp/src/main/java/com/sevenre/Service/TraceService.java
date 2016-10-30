package com.sevenre.Service;

import com.sevenre.entity.Trace;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;


@Service
public class TraceService {

    private EntityManagerFactory entityManagerFactory;

    public TraceService(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public List<Trace> getTraceById(long id){
        EntityManager entityManager = entityManagerFactory.createEntityManager( );
        Query q = entityManager.createNativeQuery("SELECT  a.trip_id as tripId ,a.time_stamp as timeStamp, a.latitude as latitude, a.longitude as longitude FROM live_location_update a where a.trip_id = :id", "tracemapping");
        q.setParameter("id", id);
        List<Trace> traces = q.getResultList();
        return traces;
    }
}
