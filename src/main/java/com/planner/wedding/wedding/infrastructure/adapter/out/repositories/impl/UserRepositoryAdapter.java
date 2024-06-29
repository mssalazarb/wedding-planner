package com.planner.wedding.wedding.infrastructure.adapter.out.repositories.impl;

import com.planner.wedding.wedding.domain.model.UserSystem;
import com.planner.wedding.wedding.domain.ports.out.UserRepository;
import com.planner.wedding.wedding.infrastructure.adapter.out.entities.UserSystemEntity;
import com.planner.wedding.wedding.infrastructure.adapter.out.mapper.UserMapper;
import com.planner.wedding.wedding.infrastructure.adapter.out.repositories.UserJpaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserRepositoryAdapter implements UserRepository {
    private final UserJpaRepository userJpaRepository;

    private final UserMapper userMapper;

    @Override
    public UserSystem create(UserSystem userSystem) {
        UserSystemEntity userSystemEntityIn = userMapper.toUserSystemEntity(userSystem);
        UserSystemEntity userSystemEntityOut = userJpaRepository.save(userSystemEntityIn);
        return userMapper.toUserSystem(userSystemEntityOut);
    }

    @Override
    public Boolean existUser(String userName) {
        UserSystemEntity userSystem = userJpaRepository.existUser(userName);
        return userSystem != null;
    }
}
