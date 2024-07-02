package com.planner.wedding.wedding.domain.ports.in;

import java.util.List;

import com.planner.wedding.wedding.domain.model.Event;

public interface EventService {
    Event create(Event event);

    List<Event> findAllEvents();
}
