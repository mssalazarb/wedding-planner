package com.planner.wedding.wedding.application;

import java.util.List;

import com.planner.wedding.wedding.domain.model.Customer;
import com.planner.wedding.wedding.domain.ports.in.CustomerService;
import com.planner.wedding.wedding.domain.ports.out.CustomerRepository;
import com.planner.wedding.wedding.infrastructure.exception.NotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.create(customer);
    }

    @Override
    public Customer findById(Long id) {
        Customer customer = customerRepository.findById(id);
        if (customer == null) {
            throw new NotFoundException("No exist customer.");
        }
        return customer;
    }
}
