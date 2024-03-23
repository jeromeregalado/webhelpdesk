package com.example.WebHelperDesk.controller;

import com.example.WebHelperDesk.entity.employee.Employee;
import com.example.WebHelperDesk.entity.ticketing.HelpdeskTicket;
import com.example.WebHelperDesk.service.WatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/watchers")
public class WatcherController {
    @Autowired
    WatcherService watcherService;

    @PostMapping("/add/{ticketNumber}")
    public HelpdeskTicket addWatcher(Integer ticketNumber, Integer employeeId){
        return watcherService.saveWatcher(ticketNumber, employeeId);
    }
}
