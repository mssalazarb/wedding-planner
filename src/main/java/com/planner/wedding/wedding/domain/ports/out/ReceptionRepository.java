package com.planner.wedding.wedding.domain.ports.out;

import com.planner.wedding.wedding.domain.model.Reception;

import java.util.List;

public interface ReceptionRepository {
    List<Reception> findAll();
    Reception create(Reception reception);
}
