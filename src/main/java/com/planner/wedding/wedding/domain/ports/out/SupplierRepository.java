package com.planner.wedding.wedding.domain.ports.out;

import java.util.List;

import com.planner.wedding.wedding.domain.model.Supplier;

public interface SupplierRepository {
    Supplier save(Supplier supplier);

    Supplier findById(Long id);

    List<Supplier> findAll();

    void deleteById(Long id);
}
