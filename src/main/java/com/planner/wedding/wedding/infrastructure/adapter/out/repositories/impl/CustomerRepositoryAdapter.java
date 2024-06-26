package com.planner.wedding.wedding.infrastructure.adapter.out.repositories.impl;

import com.planner.wedding.wedding.domain.model.Customer;
import com.planner.wedding.wedding.domain.ports.out.CustomerRepository;
import com.planner.wedding.wedding.infrastructure.adapter.out.repositories.CustomerJpaRepository;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class CustomerRepositoryAdapter implements CustomerRepository {
    private final CustomerJpaRepository customerJpaRepository;
    @Override
    public List<Customer> findAll() {
        return List.of();
    }
}
