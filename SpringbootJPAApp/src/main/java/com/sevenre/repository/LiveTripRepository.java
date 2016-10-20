package com.sevenre.repository;

import com.sevenre.entity.LiveTrip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiveTripRepository extends JpaRepository<LiveTrip,Long> {
}
