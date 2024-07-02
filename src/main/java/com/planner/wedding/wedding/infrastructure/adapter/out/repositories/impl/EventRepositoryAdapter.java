package com.planner.wedding.wedding.infrastructure.adapter.out.repositories.impl;

import java.util.List;

import com.planner.wedding.wedding.domain.model.Event;
import com.planner.wedding.wedding.domain.ports.out.EventRepository;
import com.planner.wedding.wedding.infrastructure.adapter.out.entities.EventEntity;
import com.planner.wedding.wedding.infrastructure.adapter.out.mapper.EventMapper;
import com.planner.wedding.wedding.infrastructure.adapter.out.repositories.EventJpaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EventRepositoryAdapter implements EventRepository {
    private final EventJpaRepository eventJpaRepository;
    private final EventMapper eventMapper;

    @Override
    public Event create(Event event) {
        var eventToCreate = eventMapper.toEventEntity(event);
        EventEntity response = eventJpaRepository.save(eventToCreate);

        return eventMapper.toEvent(response);
    }

    @Override
    public List<Event> findAllEvents() {
        return eventJpaRepository.findAll()
                .stream()
                .map(eventMapper::toEvent)
                .toList();
    }
}
