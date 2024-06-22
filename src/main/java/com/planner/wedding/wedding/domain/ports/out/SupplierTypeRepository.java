package com.planner.wedding.wedding.domain.ports.out;

import java.util.List;

import com.planner.wedding.wedding.domain.model.SupplierType;

public interface SupplierTypeRepository {
    SupplierType save(SupplierType supplierType);

    SupplierType findById(Long id);

    List<SupplierType> findAll();

    void deleteById(Long id);
}
