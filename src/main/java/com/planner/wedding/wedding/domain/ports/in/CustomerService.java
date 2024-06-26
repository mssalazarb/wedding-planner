package com.planner.wedding.wedding.domain.ports.in;

import com.planner.wedding.wedding.domain.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
}
