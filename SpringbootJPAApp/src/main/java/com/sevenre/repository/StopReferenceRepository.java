package com.sevenre.repository;

import com.sevenre.entity.StopReference;
import com.sevenre.entity.StopReferenceKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Arij on 10/29/2016.
 */
@Repository
public interface StopReferenceRepository extends JpaRepository<StopReference,StopReferenceKey>{
}
