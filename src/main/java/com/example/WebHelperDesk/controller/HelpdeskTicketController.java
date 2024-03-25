package com.example.WebHelperDesk.controller;

import com.example.WebHelperDesk.dto.AssignRequest;
import com.example.WebHelperDesk.dto.DeleteTicketRequest;
import com.example.WebHelperDesk.entity.ticketing.HelpdeskTicket;
import com.example.WebHelperDesk.service.HelpdeskTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class HelpdeskTicketController {
    @Autowired
    HelpdeskTicketService helpdeskTicketService;

    @PostMapping("/add")
    public HelpdeskTicket addTicket(@RequestBody HelpdeskTicket helpdeskTicket){
        return helpdeskTicketService.addTicket(helpdeskTicket);
    }

    @GetMapping("/view/{ticketNumber}")
    public HelpdeskTicket viewTicket(@PathVariable Integer ticketNumber){
        return helpdeskTicketService.viewTicketByTicketNumber(ticketNumber);
    }

    @PutMapping("/assignTicket")
    public String assignTicket(@RequestBody AssignRequest assignRequest){
       return helpdeskTicketService.assignEmployeeToTicket(assignRequest);
    }

    @DeleteMapping("/deleteTicket")
    public String deleteTicket(@RequestBody DeleteTicketRequest deleteTicketRequest){
        return helpdeskTicketService.deleteTicket(deleteTicketRequest);
    }

}
