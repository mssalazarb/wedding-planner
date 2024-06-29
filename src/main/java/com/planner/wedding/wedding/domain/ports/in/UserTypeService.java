package com.planner.wedding.wedding.domain.ports.in;

import com.planner.wedding.wedding.domain.model.UserType;

import java.util.List;

public interface UserTypeService {
    List<UserType> findAll();
}
