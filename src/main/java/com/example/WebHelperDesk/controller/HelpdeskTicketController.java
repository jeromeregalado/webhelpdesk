package com.example.WebHelperDesk.controller;

import com.example.WebHelperDesk.dto.AssignRequest;
import com.example.WebHelperDesk.dto.WatcherRequest;
import com.example.WebHelperDesk.dto.update.UpdateTicketDTO;
import com.example.WebHelperDesk.entity.ticketing.HelpdeskTicket;
import com.example.WebHelperDesk.service.HelpdeskTicketService;
import com.example.WebHelperDesk.service.WatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class HelpdeskTicketController {
    @Autowired
    HelpdeskTicketService helpdeskTicketService;
    @Autowired
    WatcherService watcherService;

    @PostMapping("watchers/addWatcher")
    public String addWatcher(@RequestBody WatcherRequest watcherRequest){
        return watcherService.saveWatcher(watcherRequest);
    }

    @PostMapping("/add")
    public HelpdeskTicket addTicket(@RequestBody HelpdeskTicket helpdeskTicket){
        return helpdeskTicketService.addTicket(helpdeskTicket);
    }

    @GetMapping("/viewAll")
    public List<HelpdeskTicket> viewAllTickets(){
        return helpdeskTicketService.viewAllTickets();
    }

    @GetMapping("/view/{ticketNumber}")
    public HelpdeskTicket viewTicket(@PathVariable Integer ticketNumber){
        return helpdeskTicketService.viewTicketByTicketNumber(ticketNumber);
    }

    @PutMapping("/assign")
    public String assignTicket(@RequestBody AssignRequest assignRequest){
       return helpdeskTicketService.assignEmployeeToTicket(assignRequest);
    }

    @DeleteMapping("/delete/{ticketNumber}")
    public String deleteTicket(@PathVariable Integer ticketNumber){
        return helpdeskTicketService.deleteTicket(ticketNumber);
    }

    @PutMapping("/update")
    public HelpdeskTicket updateTicket(@RequestBody UpdateTicketDTO updateTicketDTO){
        return helpdeskTicketService.updateTicket(updateTicketDTO);
    }
}
