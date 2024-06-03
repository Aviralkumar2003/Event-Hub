package com.miniproject.collegeminiproject.Model;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.miniproject.collegeminiproject.Service.EventService;

@Component
public class ExpiredTask {
    @Autowired
    private EventService eventService;

    @Scheduled(fixedRate = 1000)
    public void deleteExpiredEvents() {
        LocalDate currentDate = LocalDate.now();
        eventService.deleteExpiredEvents(currentDate);
    }
}