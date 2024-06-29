package com.planner.wedding.wedding.domain.ports.out;

import com.planner.wedding.wedding.domain.model.UserType;

import java.util.List;

public interface UserTypeRepository {
    List<UserType> findAll();
}
