package com.planner.wedding.wedding.infrastructure.adapter.out.repositories.impl;

import com.planner.wedding.wedding.domain.model.Customer;
import com.planner.wedding.wedding.domain.ports.out.CustomerRepository;
import com.planner.wedding.wedding.infrastructure.adapter.out.entities.CustomerEntity;
import com.planner.wedding.wedding.infrastructure.adapter.out.mapper.CustomerMapper;
import com.planner.wedding.wedding.infrastructure.adapter.out.repositories.CustomerJpaRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CustomerRepositoryAdapter implements CustomerRepository {
    private final CustomerJpaRepository customerJpaRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<Customer> findAll() {
        return customerJpaRepository.findAll().stream()
                .map(customerMapper::toCustomer)
                .toList();
    }

    @Override
    public Customer create(Customer customer) {
        CustomerEntity customerEntityIn = customerMapper.toCustomerEntity(customer);
        CustomerEntity customerEntityOut = customerJpaRepository.save(customerEntityIn);

        return customerMapper.toCustomer(customerEntityOut);
    }

    @Override
    public Customer findById(Long id) {
        CustomerEntity customer = customerJpaRepository.findById(id).orElse(null);
        return customerMapper.toCustomer(customer);
    }
}
