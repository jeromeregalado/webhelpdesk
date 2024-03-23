package com.example.WebHelperDesk.controller;

import com.example.WebHelperDesk.dto.WatcherRequest;
import com.example.WebHelperDesk.entity.ticketing.HelpdeskTicket;
import com.example.WebHelperDesk.service.WatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/watchers")
public class WatcherController {
    @Autowired
    WatcherService watcherService;

    @PostMapping("/addWatcher")
    public String addWatcher(@RequestBody WatcherRequest watcherRequest){
        return watcherService.saveWatcher(watcherRequest);
    }
}
