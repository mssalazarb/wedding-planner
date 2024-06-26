package com.planner.wedding.wedding.infrastructure.configuration;

import com.planner.wedding.wedding.application.EventServiceImpl;
import com.planner.wedding.wedding.domain.ports.in.EventService;
import com.planner.wedding.wedding.domain.ports.out.EventRepository;
import com.planner.wedding.wedding.infrastructure.adapter.out.mapper.EventMapper;
import com.planner.wedding.wedding.infrastructure.adapter.out.repositories.EventJpaRepository;
import com.planner.wedding.wedding.infrastructure.adapter.out.repositories.impl.EventRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventBeans {
    @Bean
    EventService eventService(EventJpaRepository eventJpaRepository, EventMapper eventMapper) {
        return new EventServiceImpl(this.eventRepository(eventJpaRepository, eventMapper));

    }

    EventRepository eventRepository(EventJpaRepository eventJpaRepository, EventMapper eventMapper) {
        return new EventRepositoryAdapter(eventJpaRepository, eventMapper);
    }
}
