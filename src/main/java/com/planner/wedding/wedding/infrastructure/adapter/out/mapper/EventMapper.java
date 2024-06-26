package com.planner.wedding.wedding.infrastructure.adapter.out.mapper;

import com.planner.wedding.wedding.domain.model.Event;
import com.planner.wedding.wedding.infrastructure.adapter.out.entities.EventEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventMapper {
    Event toEvent(EventEntity eventEntity);
    EventEntity toEventEntity(Event event);
}
