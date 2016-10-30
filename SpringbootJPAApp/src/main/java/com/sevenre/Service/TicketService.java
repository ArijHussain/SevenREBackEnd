package com.sevenre.Service;

import com.sevenre.entity.TicketSale;
import com.sevenre.repository.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by Arij on 10/30/2016.
 */
@Service
public class TicketService {

    private TicketRepository ticketRepository;


    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public String addTickets(List<TicketSale> ticketSales){
        ticketRepository.save(ticketSales);
        return "Tickets created successfully!";
    }

    public List<TicketSale> getAllTickets(){
        return ticketRepository.findAll();
    }

    public String updateTicket(TicketSale ticketSale){
        ticketRepository.save(ticketSale);
        return "Ticket information updated successfully!";
    }

    public String deleteTicket(TicketSale ticketSale){
        ticketRepository.delete(ticketSale);
        return "Ticket deleted successfully!";
    }

    public TicketSale getTicketById(long id){
        return ticketRepository.findOne(id);
    }

}
