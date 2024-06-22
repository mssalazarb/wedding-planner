package com.planner.wedding.wedding.infrastructure.adapter.out.repositories.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.planner.wedding.wedding.domain.model.Supplier;
import com.planner.wedding.wedding.domain.ports.out.SupplierRepository;
import com.planner.wedding.wedding.infrastructure.adapter.out.entities.SupplierEntity;
import com.planner.wedding.wedding.infrastructure.adapter.out.repositories.SupplierJpaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SupplierRepositoryAdapter implements SupplierRepository {
    private SupplierJpaRepository repository;

    @Override
    public Supplier save(Supplier supplier) {
        SupplierEntity entity = toEntity(supplier);
        return toDomain(this.repository.save(entity));
    }

    @Override
    public Supplier findById(Long id) {
        return this.repository.findById(id).map(this::toDomain).orElse(null);
    }

    @Override
    public List<Supplier> findAll() {
        return this.repository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    private SupplierEntity toEntity(Supplier supplier) {
        SupplierEntity entity = new SupplierEntity();
        entity.setId(supplier.getId());
        entity.setSupplierTypeId(supplier.getSupplierTypeId());
        entity.setPhone(supplier.getPhone());
        entity.setEmail(supplier.getEmail());
        entity.setHighStreet(supplier.getHighStreet());
        entity.setSideStreet(supplier.getSideStreet());
        entity.setCreatedAt(supplier.getCreatedAt());
        entity.setUpdatedAt(supplier.getUpdatedAt());

        return entity;
    }

    private Supplier toDomain(SupplierEntity entity) {
        Supplier supplier = new Supplier();
        supplier.setId(entity.getId());
        supplier.setSupplierTypeId(entity.getSupplierTypeId());
        supplier.setPhone(entity.getPhone());
        supplier.setEmail(entity.getEmail());
        supplier.setHighStreet(entity.getHighStreet());
        supplier.setSideStreet(entity.getSideStreet());
        supplier.setCreatedAt(entity.getCreatedAt());
        supplier.setUpdatedAt(entity.getUpdatedAt());

        return supplier;
    }
}
