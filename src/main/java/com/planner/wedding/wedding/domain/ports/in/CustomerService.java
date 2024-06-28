package com.planner.wedding.wedding.domain.ports.in;

import com.planner.wedding.wedding.domain.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer create(Customer customer);
    Customer findById(Long id);
}
