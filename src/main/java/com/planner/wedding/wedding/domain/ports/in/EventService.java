package com.planner.wedding.wedding.domain.ports.in;

import com.planner.wedding.wedding.domain.model.Event;

public interface EventService {
    Event create(Event event);
}
