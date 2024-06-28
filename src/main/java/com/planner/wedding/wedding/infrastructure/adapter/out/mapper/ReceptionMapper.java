package com.planner.wedding.wedding.infrastructure.adapter.out.mapper;

import com.planner.wedding.wedding.domain.model.Reception;
import com.planner.wedding.wedding.infrastructure.adapter.out.entities.ReceptionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReceptionMapper {
    Reception toReception(ReceptionEntity receptionEntity);

    ReceptionEntity toReceptionEntity(Reception reception);
}
