package com.example.WebHelperDesk.service;

import com.example.WebHelperDesk.dto.WatcherRequest;
import com.example.WebHelperDesk.entity.employee.Employee;
import com.example.WebHelperDesk.entity.ticketing.HelpdeskTicket;
import com.example.WebHelperDesk.exception.RecordNotFoundException;
import com.example.WebHelperDesk.repository.EmployeeRepository;
import com.example.WebHelperDesk.repository.TicketingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WatcherService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TicketingRepository ticketingRepository;


    public String saveWatcher(WatcherRequest watcherRequest) throws RecordNotFoundException {
        Optional<HelpdeskTicket> ticketOptional = ticketingRepository
                .findByTicketNumber(watcherRequest.getTicketNumber());
        Optional<Employee> employeeOptional = employeeRepository
                .findByEmployeeNumber(watcherRequest.getEmployeeNumber());
        if (ticketOptional.isPresent() && employeeOptional.isPresent()) {
            HelpdeskTicket helpdeskTicket = ticketOptional.get();
            Employee employee = employeeOptional.get();
            helpdeskTicket.getWatchers().add(employee);
            ticketingRepository.save(helpdeskTicket);
            return "Watcher added in: Ticket " + helpdeskTicket.getTitle();
        } else {
            throw new RecordNotFoundException();
        }
    }
}
