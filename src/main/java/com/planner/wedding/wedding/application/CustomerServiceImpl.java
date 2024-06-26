package com.planner.wedding.wedding.application;

import com.planner.wedding.wedding.domain.model.Customer;
import com.planner.wedding.wedding.domain.ports.in.CustomerService;
import com.planner.wedding.wedding.domain.ports.out.CustomerRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return List.of();
    }
}
