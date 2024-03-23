package com.example.WebHelperDesk.service;

import com.example.WebHelperDesk.entity.ticketing.HelpdeskTicket;
import com.example.WebHelperDesk.repository.TicketingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelpdeskTicketService {
    @Autowired
    TicketingRepository ticketingRepository;

    public HelpdeskTicket addTicket(HelpdeskTicket ticket){
        return ticketingRepository.save(ticket);
    }

}
