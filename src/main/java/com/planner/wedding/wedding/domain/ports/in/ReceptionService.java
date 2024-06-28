package com.planner.wedding.wedding.domain.ports.in;

import com.planner.wedding.wedding.domain.model.Reception;

import java.util.List;

public interface ReceptionService {
    List<Reception> findAll();
    Reception create(Reception reception);
}
