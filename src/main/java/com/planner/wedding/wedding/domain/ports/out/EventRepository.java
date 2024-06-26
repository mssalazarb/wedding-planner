package com.planner.wedding.wedding.domain.ports.out;

import com.planner.wedding.wedding.domain.model.Event;

public interface EventRepository {
    Event create(Event event);
}
