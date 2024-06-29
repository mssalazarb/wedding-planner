package com.planner.wedding.wedding.infrastructure.configuration;

import com.planner.wedding.wedding.application.UserTypeServiceImpl;
import com.planner.wedding.wedding.domain.ports.in.UserTypeService;
import com.planner.wedding.wedding.domain.ports.out.UserTypeRepository;
import com.planner.wedding.wedding.infrastructure.adapter.out.mapper.UserTypeMapper;
import com.planner.wedding.wedding.infrastructure.adapter.out.repositories.UserTypeJpaRepository;
import com.planner.wedding.wedding.infrastructure.adapter.out.repositories.impl.UserTypeRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserTypeBeans {
    @Bean
    UserTypeService userTypeService(UserTypeJpaRepository userTypeJpaRepository, UserTypeMapper userTypeMapper) {
        return new UserTypeServiceImpl(this.userTypeRepository(userTypeJpaRepository, userTypeMapper));
    }

    @Bean
    UserTypeRepository userTypeRepository(UserTypeJpaRepository userTypeJpaRepository, UserTypeMapper userTypeMapper) {
        return new UserTypeRepositoryAdapter(userTypeJpaRepository, userTypeMapper);
    }
}
