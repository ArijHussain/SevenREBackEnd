package com.sevenre.repository;

import com.sevenre.entity.Trace;
import com.sevenre.entity.TraceKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Arij on 10/29/2016.
 */
@Repository
public interface TraceRepository extends JpaRepository<Trace,TraceKey>{
}
