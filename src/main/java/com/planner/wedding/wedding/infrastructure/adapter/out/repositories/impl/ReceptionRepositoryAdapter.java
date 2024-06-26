package com.planner.wedding.wedding.infrastructure.adapter.out.repositories.impl;

import com.planner.wedding.wedding.domain.model.Customer;
import com.planner.wedding.wedding.domain.ports.out.ReceptionRepository;
import com.planner.wedding.wedding.infrastructure.adapter.out.repositories.ReceptionJpaRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ReceptionRepositoryAdapter implements ReceptionRepository {
    private final ReceptionJpaRepository receptionJpaRepository;

    @Override
    public List<Customer> findAll() {
        return List.of();
    }
}
