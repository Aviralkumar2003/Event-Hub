package com.miniproject.collegeminiproject.DAO;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniproject.collegeminiproject.Model.Event;

@Repository
public interface EventDAO extends JpaRepository<Event, Long> {
    List<Event> findByClubName(String clubName);
    List<Event> findByEventDate(LocalDate eventDate);
    List<Event> findByEventDateBefore(LocalDate currenDate);
}