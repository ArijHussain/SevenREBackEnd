package com.sevenre.Service;

import com.sevenre.entity.Driver;
import com.sevenre.entity.LiveTrip;
import com.sevenre.entity.Stop;
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

    private DriverService driverService;

    private LiveTripService liveTripService;

    private StopService stopService;


    public TicketService(TicketRepository ticketRepository,DriverService driverService,LiveTripService liveTripService,StopService stopService) {
        this.ticketRepository = ticketRepository;
        this.driverService = driverService;
        this.liveTripService = liveTripService;
        this.stopService = stopService;
    }

    public String addTickets(List<TicketSale> ticketSales){
        for(TicketSale ticketSale:ticketSales){
            Driver driver = driverService.getDriverById(ticketSale.getDriverId());
            LiveTrip liveTrip = liveTripService.getLiveTripById(ticketSale.getTripId());
            Stop stop = stopService.getStopById(ticketSale.getStopId());

            if(driver == null){
                return "Driver not found. Please check the Driver Id.";
            }

            if(stop == null){
                return "Stop not found. Please check the stop Id.";
            }

            if(liveTrip == null){
                return "Trip not found. Please check the trip Id.";
            }
        }

        ticketRepository.save(ticketSales);
        return "Tickets created successfully!";
    }

    public List<TicketSale> getAllTickets(){
        return ticketRepository.findAll();
    }

    public String updateTicket(TicketSale ticketSale){


        Driver driver = driverService.getDriverById(ticketSale.getDriverId());
        LiveTrip liveTrip = liveTripService.getLiveTripById(ticketSale.getTripId());
        Stop stop = stopService.getStopById(ticketSale.getStopId());

        if(driver == null){
            return "Driver not found. Please check the Driver Id.";
        }

        if(stop == null){
            return "Stop not found. Please check the stop Id.";
        }

        if(liveTrip == null){
            return "Trip not found. Please check the trip Id.";
        }

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
