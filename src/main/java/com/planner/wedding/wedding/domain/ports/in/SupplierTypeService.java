package com.planner.wedding.wedding.domain.ports.in;

import java.util.List;

import com.planner.wedding.wedding.domain.model.SupplierType;

public interface SupplierTypeService {
    SupplierType createSupplierType(SupplierType supplierType);

    SupplierType getSupplierTypeById(Long id);

    List<SupplierType> getAllSupplierTypes();

    SupplierType updateSupplierType(SupplierType supplierType);

    void deleteSupplierType(Long id);
}
