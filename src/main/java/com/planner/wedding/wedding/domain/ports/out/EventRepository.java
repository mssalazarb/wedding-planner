package com.planner.wedding.wedding.domain.ports.out;

import java.util.List;

import com.planner.wedding.wedding.domain.model.Event;

public interface EventRepository {
    Event create(Event event);

    List<Event> findAllEvents();
}
