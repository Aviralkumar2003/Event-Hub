package com.miniproject.collegeminiproject.Controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miniproject.collegeminiproject.Model.Event;
import com.miniproject.collegeminiproject.Service.EventService;

@Controller
public class HomeController {

    @Autowired
    EventService eventService;

    @RequestMapping("/")
    public String Home() {
        return "homepage";
    }
    @PostMapping("addEvent")
    public String addEvent(@ModelAttribute("e") Event e) {
        return eventService.addEvent(e);
    }
    @GetMapping("showEvents")
    public String showEvents(Model m) {
        return eventService.showEvents(m);
    }
    @GetMapping("club")
    public String getEventOfClub(@RequestParam String clubName, Model m) {
        return eventService.getEventOfClub(clubName, m);
    }
    @GetMapping("date")
    public String searchByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate eventDate, Model m) {
        return eventService.searchByDate(eventDate, m);
    }
}