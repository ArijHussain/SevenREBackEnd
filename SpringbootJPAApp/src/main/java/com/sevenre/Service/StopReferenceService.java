package com.sevenre.Service;

import com.sevenre.entity.StopReference;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;


@Service
public class StopReferenceService {
    private EntityManagerFactory entityManagerFactory;

    public StopReferenceService(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public List<StopReference> getSRById(long id){
        EntityManager entityManager = entityManagerFactory.createEntityManager( );
        Query q = entityManager.createNativeQuery("SELECT  a.trip_id as tripId ,a.time_stamp as timeStamp, a.stop_id as stopId FROM stop_reference a where a.trip_id = :id", "stopmapping");
        q.setParameter("id", id);
        List<StopReference> stopReferences = q.getResultList();
        return  stopReferences;
    }
}
