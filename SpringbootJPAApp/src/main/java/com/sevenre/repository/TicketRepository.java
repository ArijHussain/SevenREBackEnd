package com.sevenre.repository;

import com.sevenre.entity.TicketSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketRepository extends JpaRepository<TicketSale,Long>{
}
