package com.example.WebHelperDesk.controller;

import com.example.WebHelperDesk.entity.ticketing.HelpdeskTicket;
import com.example.WebHelperDesk.service.HelpdeskTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class HelpdeskTicketController {
    @Autowired
    HelpdeskTicketService helpdeskTicketService;

    @PostMapping("/add")
    public HelpdeskTicket addTicket(@RequestBody HelpdeskTicket helpdeskTicket){
        return helpdeskTicketService.addTicket(helpdeskTicket);
    }
}
