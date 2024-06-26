package com.planner.wedding.wedding.domain.ports.out;

import com.planner.wedding.wedding.domain.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    Customer create(Customer customer);
    Customer findById(Long id);
}
