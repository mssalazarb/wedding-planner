package com.planner.wedding.wedding.application;

import java.util.List;

import com.planner.wedding.wedding.domain.model.Reception;
import com.planner.wedding.wedding.domain.ports.in.ReceptionService;
import com.planner.wedding.wedding.domain.ports.out.ReceptionRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReceptionServiceImpl implements ReceptionService {
    private final ReceptionRepository receptionRepository;

    @Override
    public List<Reception> findAll() {
        return receptionRepository.findAll();
    }

    @Override
    public Reception create(Reception reception) {
        return receptionRepository.create(reception);
    }
}
