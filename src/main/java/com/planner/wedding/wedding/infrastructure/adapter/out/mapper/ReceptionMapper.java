package com.planner.wedding.wedding.infrastructure.adapter.out.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.planner.wedding.wedding.domain.model.Reception;
import com.planner.wedding.wedding.infrastructure.adapter.out.entities.ReceptionEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReceptionMapper {
    Reception toReception(ReceptionEntity receptionEntity);

    ReceptionEntity toReceptionEntity(Reception reception);
}
