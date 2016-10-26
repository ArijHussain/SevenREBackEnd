package com.sevenre.controller;

import com.sevenre.entity.Stop;
import com.sevenre.entity.TicketSale;
import com.sevenre.repository.TicketRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/ws/ticket")
public class TicketController {

    private TicketRepository ticketRepository;


    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    /**
     *
     * Save the Tickets
     */
    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addTickets(@RequestBody List<TicketSale> ticketSales){


        ticketRepository.save(ticketSales);
        return "Tickets created successfully!";

    }
    /**
     * Return all tickets
     */
    @RequestMapping( method = RequestMethod.GET)
    public List<TicketSale> getAllTickets(){
        return ticketRepository.findAll();

    }

    /**
     * Update ticket
     */
    @RequestMapping( method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateTicket(@RequestBody TicketSale ticketSale){
        ticketRepository.save(ticketSale);
        return "Ticket information updated successfully!";
    }


    /**
     * Delete the ticket
     */
    @RequestMapping( method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteTicket(@RequestBody TicketSale ticketSale){

        ticketRepository.delete(ticketSale);
        return "Ticket deleted successfully!";

    }


    /**
     * Return the Ticket with the specific ticketID
     */
    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public TicketSale getTicketById(@PathVariable long id){
        return ticketRepository.findOne(id);

    }
}
