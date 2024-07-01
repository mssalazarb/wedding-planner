package com.planner.wedding.wedding.infrastructure.adapter.out.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.planner.wedding.wedding.domain.model.Event;
import com.planner.wedding.wedding.infrastructure.adapter.out.entities.EventEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventMapper {
    Event toEvent(EventEntity eventEntity);

    EventEntity toEventEntity(Event event);
}
