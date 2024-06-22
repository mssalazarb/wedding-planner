package com.planner.wedding.wedding.application;

import java.util.List;

import com.planner.wedding.wedding.domain.model.Supplier;
import com.planner.wedding.wedding.domain.ports.in.SupplierService;
import com.planner.wedding.wedding.domain.ports.out.SupplierRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository repository;

    @Override
    public Supplier createSupplier(Supplier supplier) {
        return this.repository.save(supplier);
    }

    @Override
    public Supplier getSupplierById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return this.repository.findAll();
    }

    @Override
    public Supplier updateSupplier(Supplier supplier) {
        return this.repository.save(supplier);
    }

    @Override
    public void deleteSupplier(Long id) {
        this.repository.deleteById(id);
    }
}
