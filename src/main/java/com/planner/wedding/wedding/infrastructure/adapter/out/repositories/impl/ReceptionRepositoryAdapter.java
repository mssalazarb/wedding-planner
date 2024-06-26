package com.planner.wedding.wedding.infrastructure.adapter.out.repositories.impl;

import com.planner.wedding.wedding.domain.model.Customer;
import com.planner.wedding.wedding.domain.model.Reception;
import com.planner.wedding.wedding.domain.ports.out.ReceptionRepository;
import com.planner.wedding.wedding.infrastructure.adapter.out.mapper.ReceptionMapper;
import com.planner.wedding.wedding.infrastructure.adapter.out.repositories.ReceptionJpaRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ReceptionRepositoryAdapter implements ReceptionRepository {
    private final ReceptionJpaRepository receptionJpaRepository;
    private  final ReceptionMapper receptionMapper;
    @Override
    public List<Reception> findAll() {
        return receptionJpaRepository.findAll().stream()
                .map(receptionMapper::toReception)
                .toList();
    }
}
