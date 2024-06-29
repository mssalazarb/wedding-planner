package com.planner.wedding.wedding.application;

import com.planner.wedding.wedding.domain.model.UserType;
import com.planner.wedding.wedding.domain.ports.in.UserTypeService;
import com.planner.wedding.wedding.domain.ports.out.UserTypeRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UserTypeServiceImpl implements UserTypeService {
    private final UserTypeRepository userTypeRepository;

    @Override
    public List<UserType> findAll() {
        return userTypeRepository.findAll();
    }
}
