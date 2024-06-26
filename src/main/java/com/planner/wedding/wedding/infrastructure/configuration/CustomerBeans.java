package com.planner.wedding.wedding.infrastructure.configuration;

import com.planner.wedding.wedding.application.CustomerServiceImpl;
import com.planner.wedding.wedding.domain.ports.in.CustomerService;
import com.planner.wedding.wedding.domain.ports.out.CustomerRepository;
import com.planner.wedding.wedding.infrastructure.adapter.out.repositories.CustomerJpaRepository;
import com.planner.wedding.wedding.infrastructure.adapter.out.repositories.impl.CustomerRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerBeans {
    @Bean
    CustomerService customerService(CustomerJpaRepository jpaRepository) {
        return new CustomerServiceImpl(this.customerRepository(jpaRepository));
    }
    @Bean
    CustomerRepository customerRepository(CustomerJpaRepository jpaRepository) {
        return new CustomerRepositoryAdapter(jpaRepository);
    }
}
