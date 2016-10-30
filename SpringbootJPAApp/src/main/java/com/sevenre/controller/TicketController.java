package com.sevenre.controller;

import com.sevenre.Service.TicketService;
import com.sevenre.entity.Stop;
import com.sevenre.entity.TicketSale;
import com.sevenre.repository.TicketRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/ws/ticket")
public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    /**
     *
     * Save the Tickets
     */
    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addTickets(@RequestBody List<TicketSale> ticketSales){
       return ticketService.addTickets(ticketSales);
    }
    /**
     * Return all tickets
     */
    @RequestMapping( method = RequestMethod.GET)
    public List<TicketSale> getAllTickets(){
        return ticketService.getAllTickets();
    }

    /**
     * Update ticket
     */
    @RequestMapping( method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateTicket(@RequestBody TicketSale ticketSale){
        return ticketService.updateTicket(ticketSale);
    }


    /**
     * Delete the ticket
     */
    @RequestMapping( method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteTicket(@RequestBody TicketSale ticketSale){
        return ticketService.deleteTicket(ticketSale);
    }


    /**
     * Return the Ticket with the specific ticketID
     */
    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public TicketSale getTicketById(@PathVariable long id){
        return ticketService.getTicketById(id);
    }
}
