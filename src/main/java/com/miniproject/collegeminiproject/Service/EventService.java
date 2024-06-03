package com.miniproject.collegeminiproject.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.miniproject.collegeminiproject.DAO.EventDAO;
import com.miniproject.collegeminiproject.Model.Event;

@Service
public class EventService {

    @Autowired
    EventDAO eventDAO;

    @SuppressWarnings("null")
    public String addEvent(Event e) {
        eventDAO.save(e);
        return "result";
    }

    public String showEvents(Model m) {
        List<Event> events = eventDAO.findAll();
        
        events.sort(Comparator.comparing(Event::getEventDate, Comparator.nullsLast(Comparator.naturalOrder()))
                              .thenComparing(Event::getEventTime, Comparator.nullsLast(Comparator.naturalOrder())));
    
        m.addAttribute("result", events);
        return "showEvent";
    }

    public String getEventOfClub(String clubName, Model m) {
        List<Event> sortedEvents = eventDAO.findByClubName(clubName)
                .stream()
                .sorted(Comparator.comparing(Event::getEventDate, Comparator.nullsLast(Comparator.naturalOrder()))
                        .thenComparing(Event::getEventTime, Comparator.nullsLast(Comparator.naturalOrder())))
                .collect(Collectors.toList());
    
        if (sortedEvents.isEmpty()) {
            m.addAttribute("message", "No events found for the club");
        } else {
            m.addAttribute("result", sortedEvents);
        }
        return "showEvent";
    }

    public String searchByDate(LocalDate eventDate, Model m) {
        List<Event> sortedEvents = eventDAO.findByEventDate(eventDate)
                .stream()
                .sorted(Comparator.comparing(Event::getEventTime, Comparator.nullsLast(Comparator.naturalOrder())))
                .collect(Collectors.toList());

        if (sortedEvents.isEmpty()) {
            m.addAttribute("message", "No events found for the date");
        } else {
            m.addAttribute("result", sortedEvents);
        }
        return "showEvent";
    }

    @SuppressWarnings("null")
    public void deleteExpiredEvents(LocalDate currentDate) {
        List<Event> expiredEvents = eventDAO.findByEventDateBefore(currentDate);
        eventDAO.deleteAll(expiredEvents);
    }
}