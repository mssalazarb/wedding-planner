package com.planner.wedding.wedding.application;

import java.util.List;

import com.planner.wedding.wedding.domain.model.SupplierType;
import com.planner.wedding.wedding.domain.ports.in.SupplierTypeService;
import com.planner.wedding.wedding.domain.ports.out.SupplierTypeRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SupplierTypeImpl implements SupplierTypeService {

    private final SupplierTypeRepository repository;

    @Override
    public SupplierType createSupplierType(SupplierType supplierType) {
        return this.repository.save(supplierType);
    }

    @Override
    public SupplierType getSupplierTypeById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public List<SupplierType> getAllSupplierTypes() {
        return this.repository.findAll();
    }

    @Override
    public SupplierType updateSupplierType(SupplierType supplierType) {
        return this.repository.save(supplierType);
    }

    @Override
    public void deleteSupplierType(Long id) {
        this.repository.deleteById(id);
    }

}
