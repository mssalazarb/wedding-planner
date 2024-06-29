package com.planner.wedding.wedding.infrastructure.configuration;

import com.planner.wedding.wedding.application.UserServiceImpl;
import com.planner.wedding.wedding.domain.ports.out.UserRepository;
import com.planner.wedding.wedding.infrastructure.adapter.out.mapper.UserMapper;
import com.planner.wedding.wedding.infrastructure.adapter.out.repositories.UserJpaRepository;
import com.planner.wedding.wedding.infrastructure.adapter.out.repositories.impl.UserRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import com.planner.wedding.wedding.domain.ports.in.UserService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBeans {
    @Bean
    UserService userService(UserJpaRepository userJpaRepository, UserMapper userMapper) {
        return new UserServiceImpl(this.userRepository(userJpaRepository, userMapper));
    }

    @Bean
    UserRepository userRepository(UserJpaRepository userJpaRepository, UserMapper userMapper) {
        return new UserRepositoryAdapter(userJpaRepository, userMapper);
    }
}
