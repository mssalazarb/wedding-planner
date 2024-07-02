package com.planner.wedding.wedding.application;

import java.util.List;

import com.planner.wedding.wedding.domain.model.Event;
import com.planner.wedding.wedding.domain.ports.in.EventService;
import com.planner.wedding.wedding.domain.ports.out.EventRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    @Override
    public Event create(Event event) {
        return eventRepository.create(event);
    }

    @Override
    public List<Event> findAllEvents() {
        return eventRepository.findAllEvents();
    }
}
