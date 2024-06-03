package com.miniproject.collegeminiproject.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Event {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long eventId;
    private String clubName;
    private String eventName;
    private String eventDescription;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private String eventVenue; 
    private String registrationLink;
}