package com.planner.wedding.wedding.domain.ports.in;

import java.util.List;

import com.planner.wedding.wedding.domain.model.Supplier;

public interface SupplierService {
    Supplier createSupplier(Supplier supplier);

    Supplier getSupplierById(Long id);

    List<Supplier> getAllSuppliers();

    Supplier updateSupplier(Supplier supplier);

    void deleteSupplier(Long id);
}
