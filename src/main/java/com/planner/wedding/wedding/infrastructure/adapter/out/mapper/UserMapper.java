package com.planner.wedding.wedding.infrastructure.adapter.out.mapper;

import com.planner.wedding.wedding.domain.model.UserSystem;
import com.planner.wedding.wedding.infrastructure.adapter.out.entities.UserSystemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserSystem toUserSystem(UserSystemEntity userSystemEntity);

    UserSystemEntity toUserSystemEntity(UserSystem userSystem);
}
