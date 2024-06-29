package com.planner.wedding.wedding.infrastructure.adapter.out.mapper;

import com.planner.wedding.wedding.domain.model.UserType;
import com.planner.wedding.wedding.infrastructure.adapter.out.entities.UserTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserTypeMapper {
    UserType toUserType(UserTypeEntity userTypeEntity);

    UserTypeEntity toUserTypeEntity(UserType userType);
}
