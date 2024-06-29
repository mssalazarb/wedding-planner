package com.planner.wedding.wedding.application;

import com.planner.wedding.wedding.domain.model.UserSystem;
import com.planner.wedding.wedding.domain.ports.in.UserService;
import com.planner.wedding.wedding.domain.ports.out.UserRepository;
import com.planner.wedding.wedding.infrastructure.exception.NotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserSystem create(UserSystem userSystem) {
        Boolean existUser = userRepository.existUser(userSystem.getUserName());
        if (existUser) {
            throw new RuntimeException("user already exists");
        }

        return userRepository.create(userSystem);
    }
}
