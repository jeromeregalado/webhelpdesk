package com.example.WebHelperDesk.service;

import com.example.WebHelperDesk.entity.employee.Employee;
import com.example.WebHelperDesk.entity.ticketing.HelpdeskTicket;
import com.example.WebHelperDesk.repository.EmployeeRepository;
import com.example.WebHelperDesk.repository.TicketingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WatcherService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TicketingRepository ticketingRepository;


    public HelpdeskTicket saveWatcher(Integer ticketNumber, Integer employeeId) throws RuntimeException {
        Optional<HelpdeskTicket> watcherOptional = ticketingRepository.findByTicketNumber(ticketNumber);
        Optional<Employee> employeeOptional = employeeRepository.findByEmployeeNumber(employeeId);
        if (watcherOptional.isPresent() && employeeOptional.isPresent()) {
            HelpdeskTicket helpdeskTicket = watcherOptional.get();
            Employee employee = employeeOptional.get();
            employee.setTicketsWatching(helpdeskTicket);
            return ticketingRepository.save(helpdeskTicket);
        } else {
            throw new RuntimeException();
        }
    }

    public List<Employee> findAllWatchers(Integer ticketNumber, Pageable pageable) throws RuntimeException {
            return ticketingRepository.findByTicketNumber(ticketNumber).get().getWatchers();
    }

}
