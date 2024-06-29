package com.planner.wedding.wedding.infrastructure.adapter.out.repositories.impl;

import com.planner.wedding.wedding.domain.model.UserType;
import com.planner.wedding.wedding.domain.ports.out.UserTypeRepository;
import com.planner.wedding.wedding.infrastructure.adapter.out.mapper.UserTypeMapper;
import com.planner.wedding.wedding.infrastructure.adapter.out.repositories.UserTypeJpaRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UserTypeRepositoryAdapter implements UserTypeRepository {
    private UserTypeJpaRepository userTypeJpaRepository;
    private UserTypeMapper userTypeMapper;

    @Override
    public List<UserType> findAll() {
        return userTypeJpaRepository.findAll().stream()
                .map(userTypeMapper::toUserType)
                .toList();
    }
}
