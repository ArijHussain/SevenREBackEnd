package com.sevenre.repository;

import com.sevenre.entity.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface StopRepository extends JpaRepository<Stop,Long>{
}
